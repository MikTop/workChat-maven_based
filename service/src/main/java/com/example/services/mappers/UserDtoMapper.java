package com.example.services.mappers;

import com.example.database.dto.UserDto;
import com.example.database.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDtoMapper {
	
	private static final UserDtoMapper INCTANCE = new UserDtoMapper();
	
	
	public UserDto mapTo (User user) {
		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.image(user.getImage().replace('\\', '/'))
				.secondName(user.getSecondName())
				.email(user.getEmail())
				.role(user.getRole())
				.birthday(user.getBirthday())
				.build();
				
	}
	
	
	
	
	
	
	
	public static UserDtoMapper getInctance (){
		return INCTANCE;
	}
}







