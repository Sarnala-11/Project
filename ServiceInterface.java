package com.example.Service;

import com.example.DTO.DTO;
import com.example.DTO.LoginDTO;
import com.example.Response.LoginResponse;

public interface ServiceInterface 
{
	public String add(DTO dto);
	LoginResponse loginDoctor(LoginDTO loginDTO);
}
