package com.ty.TrackYantra.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.repository.AdminRepository;
import com.ty.TrackYantra.repository.EmployeeRepository;
import com.ty.TrackYantra.repository.RepotingManagerRepository;

@Repository
public class AdminDao {
	
	
	@Autowired
	AdminRepository adminRepositoryObject;
	
	@Autowired
	RepotingManagerRepository repotingManagerRepositoryObject;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public Admin saveAdmin(Admin admin)
	{
		
		return adminRepositoryObject.save(admin);
	}
	
	
	public Admin getAdminByDesignation(Designation passedDesignation)
	{
		Admin admin=null;
		try {
			
		
		 admin=adminRepositoryObject.findAdminByDesignation(passedDesignation);
		}
		catch(Exception e)
		{
			 if(admin!=null)
			 {
				 return admin;
			 }
		}
		 return null;
	}
	
	
	public Admin getAdminById(int passedAdminId)
	{
		 Optional<Admin> admin=adminRepositoryObject.findById(passedAdminId);
		 if(admin.isEmpty())
		 {
			 return admin.get();
		 }
		 return null;
	}
	
	
	public Admin getAdminByEmail(String passedEmail)
	{
		Admin admin=adminRepositoryObject.findByAdminEmail(passedEmail);
		
		if(admin!=null)
		{
			return admin;
		}
		return null;
	
	}
	
	public List<ReportingManager> getAllReportingManager()
	{
		List<ReportingManager> reportinManagerList=repotingManagerRepositoryObject.findAll();
		
		if(reportinManagerList!=null)
		{
		
			return reportinManagerList;
		}
		return null;
	}
	
	public List<Employee> getEmployeeByReportingManagerID(int passedReportingManagerId)
	{
		Optional<ReportingManager> reportingManager=repotingManagerRepositoryObject.findById(passedReportingManagerId);
		if(reportingManager!=null)
		{
			return reportingManager.get().getEmployeeList();
		}
		return null;
	}
	
	

}
