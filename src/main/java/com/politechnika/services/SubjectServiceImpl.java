package com.politechnika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.SubjectDAO;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	@Transactional
	public List<Subject> findAllByTeacher(User teacher) {
		if(teacher.getUserRole().equals(RoleName.TEACHER)) {
			return subjectDAO.findAllByTeacher(teacher);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean addSubject(Subject subject) {
		return subjectDAO.create(subject);
	}

	@Override
	@Transactional
	public boolean updateSubject(Subject subject) {
		return subjectDAO.updateSuject(subject);
	}

	@Override
	@Transactional
	public boolean removeSubject(Subject subject) {
		return subjectDAO.removeSubject(subject);
	}

	@Override
	@Transactional
	public Subject getSubject(long subjectId) {
		return subjectDAO.getSubject(subjectId);
	}

	@Override
	@Transactional
	public List<Subject> getAllSubjects() {
		return subjectDAO.getAllSubjects();
	}
}
