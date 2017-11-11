package com.politechnika.actions.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.RoleName;
import com.politechnika.models.User;
import com.politechnika.services.TeacherService;

@Role(roleNames= {RoleName.STUDENT})
public class TeacherAction extends UserAwareAction {

	private static final long serialVersionUID = 9064077612311435927L;

	private User teacher;
	
	private Long teacherId;
	
	private List<User> teachers;
	
	@Autowired
	private TeacherService teacherService;
	
	public String list() throws Exception { 
		teachers = teacherService.findAll();
		return SUCCESS;
	}
	
	public String save() throws Exception { 
		teacher.setUserRole(RoleName.TEACHER);
		teacher.setActivated(true);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
		teacherService.save(teacher);
		addActionMessage(getText("label.success"));
		return list();
	}
	
	public String delete() throws Exception {
		teacherService.delete(teacherId);
		return list();
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

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
	
}
