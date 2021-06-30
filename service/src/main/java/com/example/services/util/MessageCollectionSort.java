package com.example.services.util;

import com.example.database.entity.Message;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class MessageCollectionSort {
	
	private static MessageComparator messageComparator = new MessageComparator();

    private MessageCollectionSort() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static List<Message> sortMessageByDate(List<Message> messageCollection) {
		
		Collections.sort(messageCollection, messageComparator);
		return messageCollection;
	}
	
	
	
	private static class MessageComparator implements Comparator<Message>{

		public int compare(Message o1, Message o2) {
			if(o1.getSendDate().isBefore(o2.getSendDate())){
				return 1;
			}
			if(o1.getSendDate().isAfter(o2.getSendDate())) {
				return -1;
			}
			return 0;
		}
	}
	
}
