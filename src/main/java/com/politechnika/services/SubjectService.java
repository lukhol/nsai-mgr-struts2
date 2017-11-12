package com.politechnika.services;

import java.util.List;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectService {
	List<Subject> findAll(User user);
	boolean addSubject(Subject subject);
	boolean updateSubject(Subject subject);
	boolean removeSubject(Subject subject);
	Subject getSubject(long subjectId);
}
