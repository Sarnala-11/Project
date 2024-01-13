package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.LoginDTO;
import com.example.Entity.Doctor;
import com.example.Response.LoginResponse;
import com.example.Service.ServiceInterface;

@RestController
@CrossOrigin
public class MyController 
{
	@Autowired
	ServiceInterface service;
	@PostMapping(path="/add")
	public Doctor insert(@RequestBody Doctor doctor)
	{
		return service.insert(doctor);
	}
	
	@GetMapping("/list")
	public List<Doctor> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Doctor getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	@PutMapping("/update/{id}")
	public Doctor update(@PathVariable int id, @RequestBody Doctor doctor)
	{
		return service.update(id, doctor);
	}
	@DeleteMapping("/delete/{id}")
	public Integer delete(@PathVariable int id)
	{
		return service.delete(id);
	}
	@PostMapping(path="/login")
	public ResponseEntity<?> loginDoctor(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse=service.loginDoctor(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}
