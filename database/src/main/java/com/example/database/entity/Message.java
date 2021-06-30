package com.example.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
	
	private Long Id;
	private Integer chatId;
	private String message;
	private Integer senderId;
	private LocalDateTime sendDate;
	
	

}
