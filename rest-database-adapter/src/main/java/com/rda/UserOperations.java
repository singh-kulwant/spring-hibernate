package com.rda;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOperations implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUsers(@RequestBody User newUser) {

		Session session = createSession();

		if (null != newUser.getUserId()) {

		} else {
			newUser.setUserId(UUID.randomUUID());
			session.save(newUser);
		}

		session.getTransaction().commit();
		session.close();
		return newUser;
	}

	@RequestMapping(value = "/dropUser", method = RequestMethod.DELETE)
	public String dropUser(@RequestBody User newUser) {

		Session session = createSession();

		User usr = (User) session.load(User.class, newUser.getUserId());

		session.delete(usr);

		session.flush();

		return "User " + newUser.getUserId() + " deleted!!";
	}

	@RequestMapping(value = "/displayUsers", method = RequestMethod.GET)
	public List<User> displayUsers() {
		Session session = createSession();
		return session.createQuery("SELECT a FROM User a", User.class).getResultList();
	}

	@RequestMapping(value = ERROR_PATH)
	public String defaultError() {
		return "Something went wrong!";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	private Session createSession() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();// new transaction is created
		return session;
	}
}