package com.politechnika.services;

import java.util.List;

import com.politechnika.models.User;

public interface TeacherService {

	List<User> findAll();

	void save(User teacher);

	void delete(User teacher);

}
