package com.example.Service;

import java.util.List;

import com.example.Entity.Admin;

public interface ServiceInterface 
{
	public Admin insert(Admin admin);
	public Admin getById(int admin_id);
	public List<Admin> findAll();
}
