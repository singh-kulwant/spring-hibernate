package com.in.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.in.models.User;

@Service
public class ValidationService {

	public Boolean validUser(User user) {

		if (user == null)
			return false;

		if (ObjectUtils.isNotEmpty(user.getFirstName()) || ObjectUtils.isNotEmpty(user.getLastName())
				|| ObjectUtils.isNotEmpty(user.getCountry())) {
			return true;
		} else {
			return false;
		}
	}
}
