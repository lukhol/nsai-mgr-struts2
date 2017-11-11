package com.politechnika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politechnika.dao.SubjectDAO;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	public List<Subject> findAll(User user) {
		if(user.getUserRole().equals(RoleName.TEACHER)) {
			return subjectDAO.findAllByTeacher(user);
		} else {
			return null;
		}
	}

}
