package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.User;
import com.politechnika.models.UserRole;

public interface UserDAO {
	
	public void addStudent(User user);
	public User findByUsername(String username);
	public List<User> findAll(UserRole role);
}
