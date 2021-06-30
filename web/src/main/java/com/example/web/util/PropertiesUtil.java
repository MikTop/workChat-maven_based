package com.example.web.util;

import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public final class PropertiesUtil {

	private final static Properties INSTANCE = new Properties();
	
	static {
		loadProperties();
	}



    public static String getProperty(String key) {
		return INSTANCE.getProperty(key);
	}
	
	public static void loadProperties() {
		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("web.properties")){
			
			INSTANCE.load(inputStream);
			System.out.println();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
