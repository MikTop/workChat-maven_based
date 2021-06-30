package com.example.services.mappers;

import com.example.database.dto.ChatDto;
import com.example.database.entity.Chat;
import com.example.services.service.UserService;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChatDtoMapper {
	
	private static final ChatDtoMapper INCTANCE = new ChatDtoMapper();
	
	private final UserService userService = UserService.getInctance();
	
	public ChatDto mapTo (Chat chat) {
		
		return ChatDto.builder()
				.chatId(chat.getChatId())
				.chatsMembers(userService.findByIdList(chat.getMembersId()))
				.build();
				
	}
	
	
	
	
	
	public static ChatDtoMapper getInctance() {
		return INCTANCE;
	}
}
