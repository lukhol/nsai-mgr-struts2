package com.politechnika.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

@ParentPackage("/parentPackage")
@Namespace("/")
@Results({
	@Result(name="input", type="tiles", location="registerView"),
	@Result(name="registerComplete", type="tiles", location="registerCompleteView")
})
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 4872981664283281427L;
	
	@Autowired
	UserService userService;
	
	private User user;

	@Action("register")
	public String registerInput() throws Exception {
		return INPUT;
	}
	
	@Action("registerExecute") 
	public String registerComplete() throws Exception {
		//TO DO: set role
		userService.addUser(user);
		return "registerComplete";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
