package com.esspl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
