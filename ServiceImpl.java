package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.DTO.LoginDTO;
import com.example.Entity.Doctor;
import com.example.Repository.DaoInterface;
import com.example.Response.LoginResponse;

@Service
public class ServiceImpl implements ServiceInterface
{
	@Autowired
	DaoInterface dao;
	
	@Override
	public Doctor insert(Doctor doctor) 
	{
//		Doctor doctor=new Doctor(
//				dto.getId(),
//				dto.getName(),
//				dto.getUsername(),
//				dto.getPassword(),
//				dto.getGender(),
//				dto.getAge(),
//				dto.getSpecialization(),
//				dto.getMobilenumber(),
//				dto.getAadharnumber(),
//				dto.getLocation(),
//				this.passwordEncoder.encode(dto.getPassword())
//				);
		return dao.save(doctor);
	}

	@Override
	public List<Doctor> findAll() 
	{
		return (List<Doctor>) dao.findAll();
	}

	@Override
	public Doctor getById(int id) 
	{
		Optional<Doctor> optional=dao.findById(id);
		return optional.get();
	}
	
	@Override
	public Integer delete(int id) 
	{
		dao.deleteById(id);
		System.out.println("DELETED");
		return id;
	}

	@Override
	@Modifying
	public Doctor update(int id, Doctor doctor) 
	{
		Optional<Doctor> optional=dao.findById(id);
		Doctor doct=optional.get();
		System.out.println("Doctor : "+doct);
		doct.setName(doct.getName());
		doct.setUsername(doct.getUsername());
		doct.setPassword(doct.getPassword());
		doct.setGender(doct.getGender());
		doct.setAge(doct.getAge());
		doct.setSpecialization(doct.getSpecialization());
		doct.setMobilenumber(doct.getMobilenumber());
		doct.setAadharnumber(doct.getAadharnumber());
		doct.setLocation(doct.getLocation());
		System.out.println("Updated");
		return dao.save(doct);
	}

	@Override
	public LoginResponse loginDoctor(LoginDTO loginDTO) 
	{
		Doctor doctor1=dao.findByUsername(loginDTO.getUsername());
		if(doctor1!=null)
		{
			String password=loginDTO.getPassword();
			String encodedPassword=doctor1.getPassword();
//			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			Boolean b=password.equals(encodedPassword);
			if(b)
			{
				Optional<Doctor> doctor=dao.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
				if(doctor.isPresent())
				{
					return new LoginResponse("Login Success", true);
				}
				else
				{
					return new LoginResponse("Login Failed", false);
				}
			}
			else
			{
				return new LoginResponse("Password not match", false);
			}
		}
		else
		{
		return new LoginResponse("Email not exists", false);
		}
	}
}
