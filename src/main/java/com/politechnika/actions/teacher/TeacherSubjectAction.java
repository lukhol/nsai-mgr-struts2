package com.politechnika.actions.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.services.SubjectService;

@Role(roleNames= {RoleName.TEACHER})
public class TeacherSubjectAction extends UserAwareAction {

	private static final long serialVersionUID = 7164702001289608229L;
	
	private List<Subject> subjects;
	
	@Autowired
	private SubjectService subjectService;
	
	public String list() throws Exception {
		
		subjects = subjectService.findAll(getUser());
		return SUCCESS;
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
