package com.politechnika.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {	
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User order by id").list();
	}

	@Override
	public User findByLogin(String login) {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where login=?").setParameter(0, login).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void addRole(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
	}

	@Override
	public List<UserRole> listUserRole() {
		return sessionFactory.getCurrentSession().createQuery("from UserRole order by id").list();
	}

	@Override
	public void removeUserRole(int id) {
		UserRole userRole = (UserRole) sessionFactory.getCurrentSession().load(UserRole.class, id);
		if (null != userRole) {
			sessionFactory.getCurrentSession().delete(userRole);
		}
	}

	@Override
	public UserRole getUserRole(int id) {
		return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserRole findRoleByName(String role) {

		List<UserRole> userRole = new ArrayList<UserRole>();

		userRole = sessionFactory.getCurrentSession().createQuery("from UserRole where role=?").setParameter(0, role)
				.list();

		if (userRole.size() > 0) {
			return userRole.get(0);
		} else {
			return null;
		}
	}
}
