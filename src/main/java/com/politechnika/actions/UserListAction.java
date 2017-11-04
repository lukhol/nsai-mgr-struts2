package com.politechnika.actions;

import java.util.List;

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
	@Result(name="success", type="tiles", location="usersListView"),
	@Result(name="home", type="tiles", location="firstView")
})
public class UserListAction extends ActionSupport{
	private static final long serialVersionUID = 3641852079848617733L;

	@Autowired
	UserService userService;
	
	private List<User> users;
	
	@Action("showUsersList")
	public String showUsersList() {
		users = userService.getAllUsers();
		return SUCCESS;
	} 
	
	@Action("goHome")
	public String goHome() {
		return "home";
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
