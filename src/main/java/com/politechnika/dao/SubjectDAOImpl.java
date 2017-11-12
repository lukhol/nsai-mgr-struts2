package com.politechnika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean create(Subject subject) {
		try {
			sessionFactory.getCurrentSession().save(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Subject> findAllByTeacher(User teacher) {
		return sessionFactory.getCurrentSession().createQuery("from Subject where teacher=?").setParameter(0, teacher).list();
	}

	@Override
	public boolean updateSuject(Subject subject) {
		try {
			sessionFactory.getCurrentSession().merge(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeSubject(Subject subject) {
		try {
			sessionFactory.getCurrentSession().delete(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Subject getSubject(long subjectId) {
		return (Subject)sessionFactory.getCurrentSession().get(Subject.class, subjectId);
	}
}
