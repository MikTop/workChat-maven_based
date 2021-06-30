package com.example.services.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LocalDateFormatter {
	
	private static final String PATTERN = "yyyy-MM-dd";
	
	private static final DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern(PATTERN);

    private LocalDateFormatter() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static LocalDate format(String date) {
		return LocalDate.parse(date, dFormatter);
	}
	

}
