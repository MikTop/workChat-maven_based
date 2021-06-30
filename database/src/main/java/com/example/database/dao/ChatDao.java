package com.example.database.dao;


import com.example.database.entity.Chat;
import com.example.database.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatDao implements Dao<Integer, Chat>{
	
	private static final ChatDao INCTANCE = new ChatDao();
	
	
	private static final String SQL_CREATE_CHAT = """
			INSERT INTO all_chat (id)
			VALUES (?)
			""";
	private static final String SQL_FIND_CHAT_MEMBERS_BY_CHAT_ID = """
			SELECT member_id FROM chat 
			WHERE chat_id = ?
			""";
	
	private static final String SQL_FIND_CHATS_BY_MEMBER_ID = """
			SELECT chat_id FROM chat 
			WHERE member_id = ?
			""";
	
	private static final String SQL_ADD_NEW_CHAT = """
			INSERT INTO chat (chat_id, member_id)
			VALUES (%s, %s)
			""";
	
	private static final String SQL_FIND_CHAT_BY_ID = """
			SELECT chat_id FROM all_chat
			WHERE id = ?
			""";

	private ChatDao() {
	}


	@SneakyThrows
	public void createChat(List<Integer> chatMembers)  {
		Connection connection = null;
		Statement statement = null;
		Integer chatId = addNewChat();
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			
			
			
			for(Integer chatMember : chatMembers) {
				statement.addBatch(SQL_ADD_NEW_CHAT.formatted(chatId, chatMember));
			}
			statement.executeBatch();
			
			connection.commit();

			connection.setAutoCommit(true);
			
			}catch (Exception e) {
				if(connection != null) {
					connection.rollback();
				}
				throw e;
			}finally {
			if(connection != null) {
				connection.close();
			}


				if(statement != null) {
					statement.close();
				}
				
			}
		
					
	}
	
	@SneakyThrows
	public Integer addNewChat () {
		
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_CHAT, Statement.RETURN_GENERATED_KEYS)){
			
			preparedStatement.setObject(1, 0);
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			return resultSet.getInt(1);
		}
		
	}
	
	@SneakyThrows
	public boolean isPresent (Integer chatId) {
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CHAT_BY_ID)){
			preparedStatement.setObject(1, chatId);
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.getResultSet();
			return resultSet.next();
			
		}
	}
	
	@SneakyThrows
	public List<Integer> findMembersByChatId (Integer id){
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CHAT_MEMBERS_BY_CHAT_ID)){
			
			preparedStatement.setObject(1, id);
			preparedStatement.executeQuery();
			List<Integer> membersId = new ArrayList<>();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				membersId.add(resultSet.getInt(1));
			}
			
			return membersId;
			
			
		}
	}
	
	@SneakyThrows
	public List<Integer> findChatsByMemberId (Integer id){
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CHATS_BY_MEMBER_ID)){
			
			preparedStatement.setObject(1, id);
			preparedStatement.executeQuery();
			List<Integer> chatsId = new ArrayList<>();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				chatsId.add(resultSet.getInt(1));
			}
			
			return chatsId;
			
			
		}
	}
	
	
	@Override
	public List<Chat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Chat> findById(Integer id) {
		List<Integer> chatMembersId = findMembersByChatId(id);
		
		return Optional.ofNullable(Chat.builder()
				.chatId(id)
				.membersId(chatMembersId)
				.build());
					
	}
		
	

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chat save(Chat entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static ChatDao getInctance () {
		return INCTANCE;
	}

	

}
