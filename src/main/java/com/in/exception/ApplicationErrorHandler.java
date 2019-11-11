package com.in.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationErrorHandler {

	public static ResponseEntity handleServiceExceptions(final Throwable throwable) {

		return new ResponseEntity<>(ExceptionUtils.getRootCause(throwable).getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}