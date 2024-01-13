package com.example.DTO;

import lombok.Data;

@Data
public class LoginDTO 
{
	String username;
	String password;
	public LoginDTO(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}
	public LoginDTO() 
	{
		super();
	}
	
}
