package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectDAO {
	
	void create(Subject subject);
	List<Subject> findAllByTeacher(User teacher);
}
