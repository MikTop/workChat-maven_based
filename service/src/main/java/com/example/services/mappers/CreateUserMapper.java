package com.example.services.mappers;


import com.example.database.dto.UserCreate;
import com.example.database.entity.Role;
import com.example.database.entity.User;
import com.example.services.util.LocalDateFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper {
	
	private final static CreateUserMapper INCTANCE = new CreateUserMapper();
	private final String imagePath = "users\\";
	
	public static CreateUserMapper getInctance () {
		return INCTANCE;
	}
	
	public User MapToUser (UserCreate userCreate) {
		User user = User.builder()
				.firstName(userCreate.getFirstName())
				.secondName(userCreate.getSecondName())
				.email(userCreate.getEmail())
				.password(userCreate.getPassword())
				.image(imagePath + (userCreate.getImage().getSize() > 0 
						? userCreate.getImage().getSubmittedFileName()
								: "tiger.jpg"))
				.role(Role.find(userCreate.getRole()).orElse(null))
				.birthday(LocalDateFormatter.format(userCreate.getBirthday()))
				.id(0)
				.build();
				
		return user;
		
	}
	
}
