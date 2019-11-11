package com.in.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.in.models.User;

@Service
public class DataService {

	private Session sessionObject;

	public DataService() {

		/*
		 * configure() reads the configuration from hibernate.cfg.xml and
		 * buildSessionFactory creates the session factory object based on configuration
		 * we provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();// new transaction is created, its used to define single unit of work
		this.sessionObject = session;

	}

	public User createUser(User newUser) {
		sessionObject.save(newUser);
		Transaction transaction = sessionObject.getTransaction();
		if (transaction.isActive())
			transaction.commit();

		return newUser;

	}

}
