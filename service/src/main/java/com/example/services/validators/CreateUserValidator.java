package com.example.services.validators;

import com.example.database.dto.UserCreate;
import com.example.database.entity.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator <UserCreate>{
	
	
	private static final CreateUserValidator INCTANCE = new CreateUserValidator();
	

	@Override
	public ValidationResult isValid(UserCreate object) {
		ValidationResult validationResult = new ValidationResult();
		if(Role.find(object.getRole()) == null) {
			validationResult.add(Error.of("01", "role not valid"));
		}
			
			
			
			
		return validationResult;
	}

	
	public static CreateUserValidator getInctance() {
		return INCTANCE;
	}
	
	
	
}



