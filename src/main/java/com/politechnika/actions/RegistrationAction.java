package com.politechnika.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.StudentService;

public class RegistrationAction extends ActionSupport {
	private static final long serialVersionUID = 4872981664283281427L;
	
	@Autowired
	StudentService studentService;
	
	private User user;

	public String form() throws Exception {
		return INPUT;
	}
	
	public String register() throws Exception {
		studentService.addStudent(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
