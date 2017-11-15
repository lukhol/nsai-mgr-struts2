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
	
	private Subject subject;
	private List<Subject> savedStudentSubject;
	private List<Subject> allSubjects;
	
	public String listAll() throws Exception {
		allSubjects = subjectService.getAllSubjects();
		return SUCCESS;
	}

	public String subjectDetails() throws Exception {
		subject = subjectService.getSubject(subject.getSubjectId());
		return "subjectDetails";
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
