package com.rda;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID userId;
	private String firstName;
	private String lastName;
	private String country;
	
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

		
}
