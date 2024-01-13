package com.example.Service;

import java.util.List;

import com.example.DTO.LoginDTO;
import com.example.Entity.Doctor;
import com.example.Response.LoginResponse;

public interface ServiceInterface 
{
	public Doctor insert(Doctor doctor);
	public List<Doctor> findAll();
	public Doctor getById(int id);
	public Integer delete(int id);
	public Doctor update(int id, Doctor doctor);
	LoginResponse loginDoctor(LoginDTO loginDTO);
}
