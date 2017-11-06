package com.politechnika.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {	
		sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String login) {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, login).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
