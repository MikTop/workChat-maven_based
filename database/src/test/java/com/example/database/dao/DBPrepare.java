package com.example.database.dao;

import com.example.database.util.PropertiesUtil;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@UtilityClass
public class DBPrepare {

    private static final Properties INSTANCE = new Properties();
    private static final String createAllChatSQL = """
            create table all_chat
            (
                id int auto_increment
                    primary key
            )
            """;
    private static final String createChatSQL = """
            create table chat
            (
                member_id int          not null,
                chat_name varchar(128) null,
                chat_id   int          not null,
                primary key (member_id, chat_id),
                constraint member_id_user_id
                    foreign key (member_id) references user (id)
            )
            """;
    private static final String createMessageSQL = """
            create table message
            (
                id             bigint auto_increment
                    primary key,
                chat_id        int          not null,
                message        varchar(512) null,
                sender_id      int          not null,
                send_date_time datetime     not null,
                constraint sender_id_user_id
                    foreign key (sender_id) references user (id)
            )
            """;
    private static final String createUserSQL = """
            create table user
            (
                id          int auto_increment
                    primary key,
                first_name  varchar(120) not null,
                second_name varchar(120) not null,
                email       varchar(120) not null,
                password    varchar(120) not null,
                image       varchar(120) null,
                birthday    date         not null,
                role        varchar(24)  null,
                constraint email
                    unique (email)
            );
                        
            
            """;
    private static final String dropAllChat = """
            DROP TABLE all_chat
            """;

    private static final String dropChat = """
            DROP TABLE chat
            """;

    private static final String dropMessage = """
            DROP TABLE message
            """;

    private static final String dropUser = """
            DROP TABLE user
            """;

    private static final List<String> createTableSqlList = Arrays.asList(createUserSQL ,createAllChatSQL,createChatSQL,createMessageSQL);

    private static final List<String> dropTablesSQLList = Arrays.asList(dropAllChat, dropChat, dropMessage, dropUser);

    static {
        loadProperties();
        loadDriver();
    }

    public static void initDB(){
            createTableSqlList
                    .forEach(DBPrepare::executeSql);

    }
    public static void terminateDB (){
        for (String s: dropTablesSQLList
             ) {
            executeSql(s);
        }
    }

    @SneakyThrows
    private static void executeSql(String sqlScript){
        try(Connection connection = openConnection();
                PreparedStatement prepareStatement = connection.prepareStatement(sqlScript)){
            prepareStatement.execute();
        }
    }


    @SneakyThrows
    public static Connection openConnection(){
        return DriverManager.getConnection(PropertiesUtil.getProperty("db.url"),
                PropertiesUtil.getProperty("db.username"),
                PropertiesUtil.getProperty("db.password"));
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("dbProperties.properties")){

            INSTANCE.load(inputStream);
            System.out.println();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    private static void loadDriver() {

        Class.forName("com.mysql.cj.jdbc.Driver");


    }
}
