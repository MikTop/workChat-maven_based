package com.example.services.service;

import com.example.database.dao.ChatDao;
import com.example.database.dto.ChatDto;
import com.example.database.entity.Chat;
import com.example.services.mappers.ChatDtoMapper;
import com.example.services.util.Converter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChatService {
	
	private static final ChatService INCTANCE = new ChatService();
	
	private final UserService userService = UserService.getInctance();
	
	private final ChatDao chatDao = ChatDao.getInctance();
	private final ChatDtoMapper chatDtoMapper = ChatDtoMapper.getInctance();
	
	@SneakyThrows
	public void createNewChat (List<String> membersId) {
		
		List<Integer> chatMembers  = Converter.convertStringToInt(membersId);
		chatDao.createChat(chatMembers);
			
		
	}
	public List<ChatDto> getUserChats (Integer userId){
		List<Integer> chatsId = chatDao.findChatsByMemberId(userId);
		
		return chatsId.stream()
				.map(chat -> Chat.builder().chatId(chat).membersId(chatDao.findMembersByChatId(chat)).build())
				.map(chat -> chatDtoMapper.mapTo(chat))
				.collect(Collectors.toList());
		
		
		
	}
	
	
	
	
	public static ChatService getInctance() {
		return INCTANCE;
	}

}
