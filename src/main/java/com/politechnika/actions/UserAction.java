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
	@Result(name="success", type="tiles", location="successView"),
	@Result(name="input", type="tiles", location="firstView")
})
@Action("*Login")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 2047477076086738030L;
	
	@Autowired
	UserService userService;
	
	private User user;

	@Action("inputLogin")
	public String inputLogin() {
		return "input";
	}
	
	@Action("executeLogin")
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
