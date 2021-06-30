package com.example.services.service;

import com.example.database.dao.UserDao;
import com.example.services.mappers.UserDtoMapper;
import com.example.services.paramReoslvers.PartParamResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;


class UserServiceTest {

        private UserService userService;
        private UserDao userDao;
        private UserDtoMapper userDtoMapper;

        @BeforeEach
        void prepare(){

        }

        @Test
        void getUserByEmailAndPassword(){
                userService = Mockito.mock(UserService.class);
                //userService
        }
}
