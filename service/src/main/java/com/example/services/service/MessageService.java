package com.example.services.service;

import com.example.database.dao.MessageDao;
import com.example.database.entity.Message;
import com.example.services.util.MessageCollectionSort;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class MessageService {

	private static final MessageService INCTANCE = new MessageService();
	
	private final MessageDao messageDao = MessageDao.getInctance();
	
	public void saveMessage (Message message) {
		messageDao.save(message);
	}
	
	public List<Message> getListByChatId (Integer chatId){
		List<Message> messages = new ArrayList<>();
		
		messages.addAll(messageDao.findByChatId(chatId));
		MessageCollectionSort.sortMessageByDate(messages);
		
		return messages;
	}
	
	
	
	
	
	
	public static MessageService getInctance () {
		return INCTANCE;
	}
}
