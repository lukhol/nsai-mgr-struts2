package com.politechnika.actions.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.Post;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.models.User;
import com.politechnika.services.SubjectService;

@Role(roleNames= {RoleName.STUDENT})
public class StudentSubjectAction extends UserAwareAction implements ServletRequestAware{

	private static final long serialVersionUID = -4564450326313647263L;

	@Autowired
	SubjectService subjectService;
	
	private HttpServletRequest request;
	
	private Subject subject;
	private List<Subject> savedStudentSubjects;
	private List<Subject> allSubjects;
	
	public String listAll() throws Exception {
		allSubjects = subjectService.getAllSubjects();
		savedStudentSubjects = subjectService.getSubjectByStudent(this.getUser());
		return SUCCESS;
	}

	public String subjectDetails() throws Exception {
		subject = subjectService.getSubject(subject.getSubjectId());
		return "subjectDetails";
	}
	
	public String saveToSubject() throws Exception {
		subject = subjectService.getSubject(subject.getSubjectId());
		
		boolean contains = false;
		for(User student : subject.getStudents()) {
			if(student.getUserId() == this.getUser().getUserId()) {
				contains = true;
				break;
			}
		}
		
		if(!contains) {
			subject.getStudents().add(this.getUser());
			subjectService.updateSubject(subject);
		}
		
		allSubjects = subjectService.getAllSubjects();
		savedStudentSubjects = subjectService.getSubjectByStudent(this.getUser());
		return SUCCESS;
	}
	
	public String subjectPage() throws Exception {
		subject = subjectService.getSubject(subject.getSubjectId());
		List<Post> posts = subjectService.getPosts(subject.getSubjectId());
		subject.setPosts(posts);
		return "subjectPage";
	}
	
	/* Getters and Setters: */
	public List<Subject> getSavedStudentSubjects() {
		return savedStudentSubjects;
	}

	public void setSavedStudentSubjects(List<Subject> savedStudentSubjects) {
		this.savedStudentSubjects = savedStudentSubjects;
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
