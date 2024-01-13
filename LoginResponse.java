package com.example.Response;

public class LoginResponse 
{
	String username;
	Boolean status;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", status=" + status + "]";
	}
	public LoginResponse(String username, Boolean status) 
	{
		super();
		this.username = username;
		this.status = status;
	}
	public LoginResponse() 
	{
		super();
	}	
}
