package com.politechnika.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.Activator;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addStudent(User user) {	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(UserRole role) {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where userRole=?").setParameter(0, role.ordinal()).list();

		return users;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Activator getActivatorByUser(User user) {
		List<Activator> activators = sessionFactory.getCurrentSession().createQuery("from Activator where user=?").setParameter(0, user).list();
		
		if(activators.isEmpty())
			return null;
		
		return activators.get(0);
	}

	@Override
	public void removeActivator(Activator activator) {
		sessionFactory.getCurrentSession().delete(activator);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Activator getActivatorByCode(String code) {
		List<Activator> activators = sessionFactory.getCurrentSession().createQuery("from Activator where code=?").setParameter(0, code).list();
		if(activators.isEmpty())
			return null;
		
		return activators.get(0);
	}

	@Override
	public void addActivator(Activator activator) {
		sessionFactory.getCurrentSession().save(activator);
	}

	@Override
	public void editUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}
}
