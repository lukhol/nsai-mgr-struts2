package com.politechnika.actions;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 2047477076086738030L;
	
	@Autowired
	UserService userService;
	
	private User user;

	public String execute() throws Exception{
		userService.addUser(user);
		return "success";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
