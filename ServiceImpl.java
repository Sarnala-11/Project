package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Repository.DaoInterface;

@Service
public class ServiceImpl implements ServiceInterface
{
	@Autowired
	DaoInterface daoInterface;
	
	@Override
	public Admin insert(Admin admin) 
	{
		return daoInterface.save(admin);
	}

	@Override
	public Admin getById(int admin_id) 
	{
		Optional<Admin> optional=daoInterface.findById(admin_id);
		return optional.get();
	}

	@Override
	public List<Admin> findAll() 
	{
		return (List<Admin>) daoInterface.findAll();
	}

}
