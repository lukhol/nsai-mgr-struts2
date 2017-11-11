package com.politechnika.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.RoleName;
import com.politechnika.models.User;

@Repository
@Transactional
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> findAll() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User where userRole=?").setParameter(0, RoleName.TEACHER).list();

		if (users.size() > 0) {
			return users;
		} else {
			return new ArrayList<User>();
		}
	}

	@Override
	public void save(User newTeacher) {
		sessionFactory.getCurrentSession().save(newTeacher);
	}

	@Override
	public void delete(Long teacher) {
		sessionFactory.getCurrentSession().createQuery("delete from User where userId=?").setParameter(0, teacher).executeUpdate();
	}

}
