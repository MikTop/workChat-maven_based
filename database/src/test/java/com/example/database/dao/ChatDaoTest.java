package com.example.database.dao;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ChatDaoTest {



    @SneakyThrows
    @BeforeAll
    static void init(){
        DBPrepare.initDB();
    }
    @BeforeEach
    void prepare(){

    }




    @AfterEach
    void endOfTest(){

    }
    @AfterAll
    static void terminate(){
        DBPrepare.terminateDB();
    }

}
