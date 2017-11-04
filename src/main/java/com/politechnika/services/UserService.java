package com.politechnika.services;

import java.util.List;

import com.politechnika.models.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getAllUsers();
}
