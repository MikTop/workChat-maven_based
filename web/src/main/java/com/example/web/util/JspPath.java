package com.example.web.util;

public final class JspPath {

    private JspPath() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String getPath(String name) {
		return String.format("/WEB-INF/jsp/%s.jsp", name);
	}
	
	
	
}

