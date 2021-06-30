package com.example.services.mappers;

import com.example.database.dto.UserMinimal;
import com.example.database.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMinMapper {

	private static final UserMinMapper INCTANCE = new UserMinMapper();
	
	public UserMinimal mapTo (User user) {
		return UserMinimal.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.secondName(user.getSecondName())
				.build();
	}
	
	
	
	
	
	
	
	
	public static UserMinMapper getInctance() {
		return INCTANCE;
	}
}
