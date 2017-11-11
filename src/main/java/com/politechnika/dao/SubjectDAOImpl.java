package com.politechnika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(Subject subject) {
		sessionFactory.getCurrentSession().save(subject);
	}

	@Override
	public List<Subject> findAllByTeacher(User teacher) {
		return sessionFactory.getCurrentSession().createQuery("from Subject where teacher=?").setParameter(0, teacher).list();
	}

}
