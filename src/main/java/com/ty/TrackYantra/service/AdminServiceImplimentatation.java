package com.ty.TrackYantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.DesignationNotFoundException;
import com.ty.TrackYantra.exception.EmailNotFoundException;
import com.ty.TrackYantra.exception.IdNotFoundException;

@Service
public class AdminServiceImplimentatation implements AdminService {
	
	@Autowired
	AdminDao adminDaoObject;

	@Override
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin passedAdmin) {
		// TODO Auto-generated method stub
		Admin admin=adminDaoObject.saveAdmin(passedAdmin);
		if(admin!=null)
		{
			ResponseStructure<Admin> resp= new ResponseStructure<Admin>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(admin);
			
			return new ResponseEntity<ResponseStructure<Admin>>(resp,HttpStatus.ACCEPTED);
			
			
		}
		//throw exception 
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Admin>> getAdminByDesignation(Designation passedDesignation) {
		// TODO Auto-generated method stub
		Admin admin=adminDaoObject.getAdminByDesignation(passedDesignation);
		if(admin!=null)
		{
			ResponseStructure<Admin> resp= new ResponseStructure<Admin>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(resp,HttpStatus.ACCEPTED);
			
		}
		//throw Admin Doesnot Exist For Given Designation
		
		throw new DesignationNotFoundException("Designation Not Found : "+passedDesignation);
	}

	@Override
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int passedId) {
		
		Admin admin=adminDaoObject.getAdminById(passedId);
		if(admin!=null)
		{
			ResponseStructure<Admin> resp= new ResponseStructure<Admin>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(resp,HttpStatus.ACCEPTED);
			
		}

		//throw Admin Doesnot Exist For Given Id
		throw new IdNotFoundException("Admin Does Not Exist For The Given Id : "+passedId);
	}

	@Override
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String passedEmail) {
		// TODO Auto-generated method stub
		
		Admin admin=adminDaoObject.getAdminByEmail(passedEmail);
		
		if(admin!=null)
		{
			ResponseStructure<Admin> resp= new ResponseStructure<Admin>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(resp,HttpStatus.ACCEPTED);
			
		}
		

		//throw Admin Doesnot Exist For Given Email
		throw new EmailNotFoundException("Admin Does Not Exist For The Specified Email :"+passedEmail);
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ReportingManager>>> getAllReportingManager() {
		// TODO Auto-generated method stub
		
		List<ReportingManager> repoManagerList=adminDaoObject.getAllReportingManager();
		
		if(repoManagerList!=null)
		{
			ResponseStructure<List<ReportingManager>> resp= new ResponseStructure<List<ReportingManager>>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(repoManagerList);
			return new ResponseEntity<ResponseStructure<List<ReportingManager>>>(resp,HttpStatus.ACCEPTED);
			
		}
		
		// throw no Reporting Manager Found
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByReportingManagerID(
			int passedReportingManagerId) {
		// TODO Auto-generated method stub
		
		List<Employee> employeeList=adminDaoObject.getEmployeeByReportingManagerID(passedReportingManagerId);
		
		if(employeeList!=null)
		{
			ResponseStructure<List<Employee>> resp= new ResponseStructure<List<Employee>>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(employeeList);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(resp,HttpStatus.ACCEPTED);
			
			
		}
			
		// manager does not exist for givenId
		throw new IdNotFoundException("Employee Not Found For Specified Reporting Manager Id : "+passedReportingManagerId);
		
	}

<<<<<<< HEAD
	
	
=======

>>>>>>> 7d0d9346d9ceeae808195ac6c8fbc71eae4118ac

}
