package com.politechnika.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.models.UserContext;
import com.politechnika.services.UserService;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final String USER = "USER";

	private static final long serialVersionUID = 2047477076086738030L;

	private Map<String, Object> session = new HashMap<>();

	private String username;
	
	private String password;
	
	@Autowired
	private UserService userService;

	public String login() throws Exception {
		
		User user = userService.findByUsername(this.username);
		
		if(user == null) {
			addActionError(getText("errors.wrong.username"));
			return ERROR;
		}
		
		
		if(!validPassword(user)) {
			addActionError(getText("errors.wrong.password"));
			return ERROR;
		}
			
		UserContext context = new UserContext();
		context.setUserId(user.getId());
		context.setRole(user.getUserRole());

		// put the user context to the session parameter
		this.session.put(USER, context);

		return SUCCESS;
	}

	private boolean validPassword(User user) {
		
		return !StringUtils.isEmpty(this.password) ? userService.hashPassword(this.password).equals(user.getPassword()) : false;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
}
