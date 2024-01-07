package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Service.ServiceInterface;

@RestController
@CrossOrigin
public class MyController 
{
	@Autowired
	ServiceInterface service;
	
	@PostMapping("/add")
	public Admin insert(@RequestBody Admin admin)
	{
		return service.insert(admin);
	}
	@GetMapping("/view/{admin_id}")
	public Admin getById(@PathVariable int admin_id)
	{
		return service.getById(admin_id);
	}
	@GetMapping("/list")
	public List<Admin> findAll()
	{
		return service.findAll();
	}
}
