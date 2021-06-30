package com.example.services.mappers;


import com.example.database.dto.UserCreate;
import com.example.database.entity.User;
import com.example.services.extensions.NullPointerExtension;
import com.example.services.paramReoslvers.PartParamResolver;
import jakarta.servlet.http.Part;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

@ExtendWith({
        NullPointerExtension.class,
        PartParamResolver.class
})
class CreateUserMapperTest {
    private CreateUserMapper createUserMapper;


        @BeforeAll
        static void init(){

        }
        @BeforeEach
        void prepare(){
            createUserMapper = CreateUserMapper.getInctance();

        }


        @ParameterizedTest
        @MethodSource("getUsersWithDifferentDummyFields")
        void userShouldBeNotCreate(UserCreate userCreate){
            UserCreate userCreate1 = Mockito.spy(userCreate);
            Mockito.doReturn(0).when(userCreate1).getImage().getSize();
            User user = createUserMapper.MapToUser(userCreate);

            Assertions.assertThat(user).isNotNull();


        }

        static Stream<Arguments> getUsersWithDifferentDummyFields(){

            return Stream.of(
              Arguments.of(UserCreate.builder().build()),
              Arguments.of(UserCreate.builder()
                      .firstName("")
                      .secondName("")
                      .password("")
                      .role("")
                      .birthday("")
                      .email("")
                      .build()),
              Arguments.of(UserCreate.builder()
                      .firstName(Mockito.anyString())
                      .secondName("")
                      .role("")
                      .birthday("")
                      .email("")
                      .build()),
                    Arguments.of(UserCreate.builder()
                            .firstName(null)
                            .secondName(null)
                            .role(null)
                            .birthday(null)
                            .email(null)
                            .build())
            );
        }
        @AfterEach
        void end(){

        }

}
