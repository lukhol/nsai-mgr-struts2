package com.politechnika.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 4872981664283281427L;
	
	@Autowired
	UserService userService;
	
	private User user;

	public String register() throws Exception {
		return INPUT;
	}
	
	public String complete() throws Exception {
		userService.addUser(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
