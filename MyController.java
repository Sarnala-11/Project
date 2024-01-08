package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.DTO;
import com.example.DTO.LoginDTO;
import com.example.Response.LoginResponse;
import com.example.Service.ServiceInterface;

@RestController
@CrossOrigin
public class MyController 
{
	@Autowired
	ServiceInterface service;
	@PostMapping(path="/save")
	public String insert(@RequestBody DTO dto)
	{
		String id=service.add(dto);
		return id;
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginDoctor(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse=service.loginDoctor(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}
