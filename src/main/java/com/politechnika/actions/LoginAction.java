package com.politechnika.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final String USER = "USER";
	private static final long serialVersionUID = 2047477076086738030L;

	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	private String username;
	private String password;
	
	@Autowired
	private UserService userService;
	
	private HttpServletRequest request;
	
	public String input() throws Exception {
		if(request.getSession().getAttribute(USER) != null) {
			logger.info("Login action - user is logged in. Home page will display.");
			return "home";
		}
		
		return INPUT;
	}

	public String login() throws Exception {
		
		if(!myValidate())
			return Action.LOGIN;
		
		User user = userService.findByUsername(this.username);
		
		if(user == null || !userService.validPassword(user, password)) {
			addFieldError("username", getText("errors.wrong.loginCredential"));
			return ERROR;
		}
		
		if(!user.isActivated()) {
			addFieldError("userNotActivated", getText("errors.userNotActivated"));
			return ERROR;
		}

		// put the user to the session parameter
		request.getSession().setAttribute(USER, user);

		return SUCCESS;
	}
	
	public String logout() throws Exception {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute(USER);
		
		if(user != null) {
			session.removeAttribute(USER);
		}
		
		return Action.LOGIN;
	}
	
	private boolean myValidate(){
		boolean validateResult = true;
		if(StringUtils.isEmpty(username)){
			addFieldError("username", getText("validation.field.required"));
			validateResult = false;
		}
		if(StringUtils.isEmpty(password)){
			addFieldError("password", getText("validation.field.required"));
			validateResult = false;
		}
		
		return validateResult;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
