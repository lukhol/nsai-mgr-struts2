package com.politechnika.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final String USER = "USER";
	private static final long serialVersionUID = 2047477076086738030L;

	private String username;
	private String password;
	
	@Autowired
	private UserService userService;
	private HttpServletRequest request;
	
	public String form() throws Exception {
		return INPUT;
	}

	public String login() throws Exception {
		
		User user = userService.findByUsername(this.username);
		
		if(user == null || !validPassword(user)) {
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

	private boolean validPassword(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(this.password, user.getPassword());
	}
	
	public void validate(){
		if(StringUtils.isEmpty(username)){
			addFieldError("username", getText("validation.field.required"));
		}
		if(StringUtils.isEmpty(password)){
			addFieldError("password", getText("validation.field.required"));
		}
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
