package com.politechnika.actions.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.RoleName;
import com.politechnika.models.User;
import com.politechnika.services.TeacherService;

@Role(roleNames= {RoleName.STUDENT})
public class TeacherAction extends UserAwareAction {

	private static final long serialVersionUID = 9064077612311435927L;

	private User teacher;
	
	private List<User> teachers;
	
	@Autowired
	private TeacherService teacherService;
	
	public String list() throws Exception { 
		teachers = teacherService.findAll();
		return SUCCESS;
	}
	
	public String save() throws Exception { 
		teacherService.save(teacher);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		teacherService.delete(teacher);
		return SUCCESS;
	}
	
	public String edit() throws Exception {
		return INPUT;
	}
	
	/* GETTERS and SETTERS */
	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}
}
