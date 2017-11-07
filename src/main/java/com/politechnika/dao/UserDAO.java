package com.politechnika.dao;

import com.politechnika.models.User;

public interface UserDAO {
	
	public void addStudent(User user);
	public User findByUsername(String username);
}
