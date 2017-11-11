package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.User;

public interface TeacherDAO {

	List<User> findAll();

	void save(User newTeacher);
	
	void edit(User teacher);

	void delete(Long teacherId);

	User find(Long teacherId);

}
