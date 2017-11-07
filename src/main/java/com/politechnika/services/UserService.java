package com.politechnika.services;

import com.politechnika.models.User;

public interface UserService {
	
	public void addStudent(User user);
	public User findByUsername(String username);
}
