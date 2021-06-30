package com.example.services.util;

import java.util.Random;

public final class RandomGenerator {
	private static final Random random = new Random(28);

    private RandomGenerator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String getRandomString(Integer length) {
		
		char[] allSimbols ="abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i =0; i<length; i++) {
			stringBuilder.append(allSimbols[random.nextInt(allSimbols.length)]);
		}
		System.out.println(stringBuilder);
		return stringBuilder.toString();
		
	}
	public static Integer getRandomint() {
		return random.nextInt();
	}
	
}
