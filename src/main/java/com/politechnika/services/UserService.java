package com.politechnika.services;

import com.politechnika.models.User;

public interface UserService {
	
	User findByUsername(String username);
	boolean activateUser(User user, String activationCode);
	boolean validPassword(User user, String password);
}
