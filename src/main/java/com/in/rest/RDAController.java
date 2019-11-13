package com.in.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.models.User;
import com.in.service.DataService;
import com.in.service.ValidationService;

@RestController
public class RDAController {

	@Autowired
	DataService dataService;

	@Autowired
	ValidationService validationService;

	@PostMapping(value = "/user")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody User user) {

		try {
			if (validationService.validUser(user)) {
				return ResponseEntity.ok(dataService.createUser(user));
			} else {
				return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<User> displayUser(@PathVariable UUID userId) {
		return ResponseEntity.ok(dataService.findUser(userId));

	}
	
	/*
	 * @GetMapping(value = "/users") public ResponseEntity<List<User>>
	 * displayUsers() { return ResponseEntity.ok(dataService.findAllUsers()); }
	 */

	/*
	 * 
	 * 
	 * 
	 * @PutMapping(value = "/user")
	 * 
	 * @ResponseBody public User updateUser(@RequestBody User user) {
	 * 
	 * sessionObject.update("User", user); sessionObject.getTransaction().commit();
	 * return user; }
	 * 
	 * @DeleteMapping(value = "/user/{userId}") public String dropUser(@PathVariable
	 * UUID userId) {
	 * 
	 * sessionObject.delete(sessionObject.find(User.class, userId));
	 * 
	 * sessionObject.flush();
	 * 
	 * return "User " + userId + " deleted!!"; }
	 */

}
