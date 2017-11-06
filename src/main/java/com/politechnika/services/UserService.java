package com.politechnika.services;

import com.politechnika.models.User;

public interface UserService {
	
	public void addUser(User user);
	public User findByUsername(String username);
	public String hashPassword(String password);
}
