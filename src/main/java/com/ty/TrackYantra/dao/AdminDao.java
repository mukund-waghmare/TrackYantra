package com.ty.TrackYantra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.repository.AdminRepository;

@Repository
public class AdminDao {
	
	
	@Autowired
	AdminRepository adminRepositoryObject;
	
	
	public Admin saveAdmin(Admin admin)
	{
		
		return adminRepositoryObject.save(admin);
	}
	
	
	public Admin getAdminByDesignation(Designation designation)
	{
		return adminRepositoryObject.findAdminByDesignation(designation);
	}

}
