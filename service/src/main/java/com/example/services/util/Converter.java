package com.example.services.util;

import java.util.ArrayList;
import java.util.List;


public final class Converter {

    private Converter() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static List<Integer> convertStringToInt(List<String> list){
		List<Integer> resultList = new ArrayList<>();
		for (String s : list) {
			resultList.add(Integer.valueOf(s));
		}
		return resultList;
	}

}
