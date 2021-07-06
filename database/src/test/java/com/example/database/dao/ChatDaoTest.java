package com.example.database.dao;

import com.example.database.entity.Chat;
import com.example.database.entity.Role;
import com.example.database.entity.User;
import com.example.database.util.ConnectionManager;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class ChatDaoTest {
    private final ChatDao chatDao = ChatDao.getInctance();
    private final UserDao userDao = UserDao.getInstance();
    private static final Random random = new Random(15);



    @BeforeAll
    static void init() {

    }

    @BeforeEach
    void prepare() {
        DBPrepare.initDB();
        for (int i = 0; i < 10; i++) {
            userDao.save(User.builder()
                    .birthday(LocalDate.of(1970, 1, 1))
                    .email(Mockito.anyString() + i)
                    .firstName(Mockito.anyString())
                    .image(Mockito.anyString())
                    .password(Mockito.anyString())
                    .role(Role.Admin)
                    .secondName(Mockito.anyString())
                    .id(0)
                    .build());
        }


    }

    @Nested
    class CreateChat {
        @SneakyThrows
        @ParameterizedTest
        @MethodSource("com.example.database.dao.ChatDaoTest#getChatMembers")
        void chatShouldBeCreate(List<Integer> members) {

            chatDao.createChat(members);
            List<Integer> result = chatDao.findMembersByChatId(1);
            Assertions.assertThat(result).isEqualTo(members);


        }


    }
    @Nested
    class AddNewChat{
        @Test
        void shouldBeAddedNewChatId(){

            Assertions.assertThat(chatDao.addNewChat()).isPositive();
        }

        @Test
        void ChatShouldBePresentWithId(){
            for (int i = 0; i < 10; i++) {

                Assertions.assertThat(chatDao.addNewChat()).isEqualTo(i+1);
            }

        }

    }


    @AfterEach
    void endOfTest() {
        DBPrepare.terminateDB();
    }

    @AfterAll
    static void terminate() {

    }

    private static Stream<Arguments> getChatMembers() {
        return Stream.of(
                Arguments.of(List.of(random.nextInt(9)))

        );

    }
}
