package com.example.services.validators;

public interface Validator<T>{
	
	public ValidationResult isValid(T object);

}
