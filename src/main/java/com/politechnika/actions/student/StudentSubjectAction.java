package com.politechnika.actions.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.services.SubjectService;

@Role(roleNames= {RoleName.STUDENT})
public class StudentSubjectAction extends UserAwareAction{

	private static final long serialVersionUID = -4564450326313647263L;

	@Autowired
	SubjectService subjectService;
	
	private List<Subject> savedStudentSubject;
	private List<Subject> allSubjects;
	
	public String list() throws Exception {
		
		return SUCCESS;
	}

	/* Getters and Setters: */
	public List<Subject> getSavedStudentSubject() {
		return savedStudentSubject;
	}

	public void setSavedStudentSubject(List<Subject> savedStudentSubject) {
		this.savedStudentSubject = savedStudentSubject;
	}

	public List<Subject> getAllSubjects() {
		return allSubjects;
	}

	public void setAllSubjects(List<Subject> allSubjects) {
		this.allSubjects = allSubjects;
	}
}
