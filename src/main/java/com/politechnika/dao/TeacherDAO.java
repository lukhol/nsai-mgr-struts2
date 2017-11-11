package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.User;

public interface TeacherDAO {

	List<User> findAll();

	void save(User newTeacher);

	void delete(User teacher);

}
