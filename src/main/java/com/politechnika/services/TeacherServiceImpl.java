package com.politechnika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politechnika.dao.TeacherDAO;
import com.politechnika.models.User;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	public List<User> findAll() {
		return teacherDAO.findAll();
	}

	@Override
	public void save(User teacher) {
		teacherDAO.save(teacher);
	}

	@Override
	public void delete(User teacher) {
		teacherDAO.delete(teacher);
	}

}
