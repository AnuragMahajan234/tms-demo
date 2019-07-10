package com.yash.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class LoginnameException extends RuntimeException {
	
	private static final long serialVersionID = 1L;

	public LoginnameException(String message) {
		super(message);
	}

}
