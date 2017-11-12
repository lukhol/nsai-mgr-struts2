package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectDAO {
	
	boolean create(Subject subject);
	List<Subject> findAllByTeacher(User teacher);
	boolean updateSuject(Subject subject);
	boolean removeSubject(Subject subject);
	Subject getSubject(long subjectId);
}
