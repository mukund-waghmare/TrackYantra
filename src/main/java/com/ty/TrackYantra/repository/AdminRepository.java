package com.ty.TrackYantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	
	
	public Admin findAdminByDesignation(Designation designation);
}
