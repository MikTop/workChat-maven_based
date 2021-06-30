package com.example.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private String image;
	private LocalDate birthday;
	private Role role;
	
}
