package com.politechnika.services;

import com.politechnika.models.User;

public interface UserService {
	
	User findByUsername(String username);
}
