package com.politechnika.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 2047477076086738030L;
	
	private User user;

	public String execute() throws Exception{
		return "success";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
