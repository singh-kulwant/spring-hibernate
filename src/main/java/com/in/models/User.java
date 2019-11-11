package com.in.models;

import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)", name = "USER_ID")
	private UUID userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;

	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "RESI_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "RESI_CITY")),
			@AttributeOverride(name = "country", column = @Column(name = "RESI_COUNTRY")),
			@AttributeOverride(name = "pincode", column = @Column(name = "RESI_PINCODE")) })
	private Address currentAddress;

	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "PERM_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "PERM_CITY")),
			@AttributeOverride(name = "country", column = @Column(name = "PERM_COUNTRY")),
			@AttributeOverride(name = "pincode", column = @Column(name = "PERM_PINCODE")) })
	private Address permanenetAddress;

	public UUID getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public Address getPermanenetAddress() {
		return permanenetAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public void setPermanenetAddress(Address permanenetAddress) {
		this.permanenetAddress = permanenetAddress;
	}

}
