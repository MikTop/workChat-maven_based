package com.example.services.exception;

import java.util.List;


public class MyAppException extends RuntimeException {
	
	private List<Error> errors;
	
	public MyAppException(List<Error> errors) {
		this.errors = errors;
	}
	
}
