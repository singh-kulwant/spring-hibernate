package com.in.rest;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.models.User;

@RestController
public class RDAController {

	private Session sessionObject;

	public RDAController() {

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

	@PostMapping(value = "/user")
	@ResponseBody
	public User createUsers(@RequestBody User newUser) {

		if (null != newUser.getUserId()) {

		} else {
			newUser.setUserId(UUID.randomUUID());
			sessionObject.save(newUser);
		}

		endSession();
		return newUser;
	}

	@PutMapping(value = "/user")
	@ResponseBody
	public User updateUser(@RequestBody User user) {

		sessionObject.update("User", user);
		endSession();
		return user;
	}

	private void endSession() {
		sessionObject.getTransaction().commit();
		sessionObject.close();
	}

	@DeleteMapping(value = "/user/{userId}")
	public String dropUser(@PathVariable UUID userId) {

		sessionObject.delete(sessionObject.find(User.class, userId));

		sessionObject.flush();

		return "User " + userId + " deleted!!";
	}

	@GetMapping(value = "/user")
	public List<User> displayUsers() {
		return sessionObject.createQuery("SELECT a FROM User a", User.class).getResultList();
	}

}
