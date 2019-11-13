package com.in.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.models.User;

@Service
public class DataService {

	@Autowired
	private SessionFactory sessionFactory;

	public User createUser(User newUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(newUser);
		session.getTransaction().commit();
		session.close();
		return newUser;
	}

	public User findUser(UUID userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return session.get(User.class, userId);
		} finally {
			session.close();
		}
	}

	/*
	 * public List<User> findAllUsers() { // return
	 * sessionObject.getNamedQuery(queryName); return
	 * sessionObject.createQuery("SELECT a FROM USER_DETAILS a",
	 * User.class).getResultList(); }
	 */
}
