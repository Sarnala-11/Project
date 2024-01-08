package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DTO.DTO;
import com.example.DTO.LoginDTO;
import com.example.Entity.Doctor;
import com.example.Repository.DaoInterface;
import com.example.Response.LoginResponse;

@Service
public class ServiceImpl implements ServiceInterface
{
	@Autowired
	DaoInterface dao;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public String add(DTO dto) 
	{
		Doctor doctor=new Doctor(
				dto.getId(),
				dto.getName(),
				dto.getUsername(),
				dto.getPassword(),
				dto.getGender(),
				dto.getAge(),
				dto.getSpecialization(),
				dto.getMobilenumber(),
				dto.getAadharnumber(),
				dto.getLocation(),
				this.passwordEncoder.encode(dto.getPassword())
				);
		dao.save(doctor);
		return "Inserted";
	}

	@Override
	public LoginResponse loginDoctor(LoginDTO loginDTO) 
	{
		String msg=" ";
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
