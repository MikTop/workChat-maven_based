package com.example.services.service;

import com.example.database.dao.UserDao;
import com.example.database.dto.UserCreate;
import com.example.database.dto.UserDto;
import com.example.database.dto.UserMinimal;
import com.example.database.entity.User;
import com.example.services.mappers.CreateUserMapper;
import com.example.services.mappers.UserDtoMapper;
import com.example.services.mappers.UserMinMapper;
import com.example.services.validators.CreateUserValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
	
	private static final UserService INCTANCE = new UserService();
	
	
	
	private final UserDao userDao = UserDao.getInstance();
	private final CreateUserMapper createUserMapper = CreateUserMapper.getInctance();
	private final CreateUserValidator createUserValidator = CreateUserValidator.getInctance();
	private final UserDtoMapper userDtoMapper = UserDtoMapper.getInctance();
	private final ImageService imageService = ImageService.getInctance();
	private final UserMinMapper userMinMapper = UserMinMapper.getInctance();
	
	
	
	@SneakyThrows
	public User createUser (UserCreate userCreate) {
		User user = createUserMapper.MapToUser(userCreate);
		/*if(userCreate.getImage().getSize() > 0) {
		imageService.saveImage(user.getImage(), userCreate.getImage().getInputStream());
		}else {
			user.setImage("users\\tiger.jpg");
		}
		// TODO Вынести в маппер эту проверку
		 * */
		 
		return userDao.save(user);
		
		}
	
	
	
	public Optional<UserDto> getUserByEmailAndPassword (String email, String password) {
		
		return userDao.findByEmailAndPassword(email, password)
				.map(user -> userDtoMapper.mapTo(user));
		
		}
	
public List<UserMinimal> findAll () {
		
		return userDao.findAll().stream()
				.map(user -> userMinMapper.mapTo(user))
				.collect(Collectors.toList());
		
		}

public List<UserMinimal> findByIdList (List<Integer> membersId ){
	List<User> members;
	members = userDao.findByIdList(membersId);
	
	
	return members.stream()
			.map(user -> userMinMapper.mapTo(user))
			.collect(Collectors.toList());
}
	
	
	
	
	public static UserService getInctance() {
		return INCTANCE;
	}

}
