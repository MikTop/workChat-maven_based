package com.example.database.util;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionManager {
	
	
	
	private final static String URL_KEY = "db.url";
	private final static String USERNAME_KEY = "db.username";
	private final static String PASSWORD_KEY = "db.password";
	
	private static final Integer POOL_SIZE = 10;
	
	private static BlockingQueue<Connection> pool;
	private static List<Connection> connections;
	
	
	static {
		loaddriver();
		initPoolConnection();
	}

	private ConnectionManager() {
	}

	private static void initPoolConnection() {
		
		pool = new ArrayBlockingQueue<>(POOL_SIZE);
		connections = new ArrayList<>();
		
		for (int i = 0; i < POOL_SIZE; i++) {
			Connection connection = openConnection();			
			Connection proxyConnection = (Connection)Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(),
					new Class[] {Connection.class}, 
					(InvocationHandler) (proxy, method, args) -> 
				(method.getName().equals("close")) 
				? pool.add((Connection)proxy)
				: method.invoke(connection, args));
			
			pool.add(proxyConnection);
			connections.add(connection);								
		}
	}
	
	@SneakyThrows
	public static void closePool() {
		for(Connection connection : connections) {
			connection.close();
		}
	}
	
	@SneakyThrows
	public static Connection getConnection() {
		
			return pool.take();
		
	}
	
	@SneakyThrows
	private static Connection openConnection(){
		return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY), 
				PropertiesUtil.getProperty(USERNAME_KEY), 
				PropertiesUtil.getProperty(PASSWORD_KEY));
	}

	@SneakyThrows
	private static void loaddriver() {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
}
