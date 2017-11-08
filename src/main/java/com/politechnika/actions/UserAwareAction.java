package com.politechnika.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;

public abstract class UserAwareAction extends ActionSupport {
	
	private static final long serialVersionUID = 7252201647920094845L;
	
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	
}
