package com.example.database.dao;

import com.example.database.entity.Message;
import com.example.database.entity.Role;
import com.example.database.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageDaoTest {
    private final UserDao userDao = UserDao.getInstance();
    private final MessageDao messageDao = MessageDao.getInctance();
    private final ChatDao chatDao = ChatDao.getInctance();
    private final static Random random = new Random(15);

    @BeforeEach
    void prepare() {
        DBPrepare.initDB();
        List<User> membersList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user =User.builder()
                    .birthday(LocalDate.of(1970, 1, 1))
                    .email(Mockito.anyString() + i)
                    .firstName(Mockito.anyString())
                    .image(Mockito.anyString())
                    .password(Mockito.anyString())
                    .role(Role.Admin)
                    .secondName(Mockito.anyString())
                    .id(i+1)
                    .build();
            membersList.add(user);
            userDao.save(user);
        }
        chatDao.createChat(membersList.stream()
        .map(User::getId)
        .collect(Collectors.toList()));



    }

    @ParameterizedTest
    @MethodSource("getMessages")
    void messageShouldBeSaved(Message message){
        messageDao.save(message);
        Assertions.assertThat(messageDao.findByChatId(1)).isNotEmpty();
        Assertions.assertThat(messageDao.findByChatId(1).get(0)).isInstanceOf(Message.class);
    }


    @AfterEach
    void endOfTest() {
        DBPrepare.terminateDB();
    }

    static Stream<Arguments> getMessages(){
        List<Arguments> argumentsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            argumentsList.add(Arguments.of(
                    Message.builder()
                            .Id(0L)
                            .message(Mockito.anyString())
                            .chatId(1)
                            .sendDate(LocalDateTime.now())
                            .senderId(i+1)
                            .build()
            ));
        }
        return argumentsList.stream();
    }
}
