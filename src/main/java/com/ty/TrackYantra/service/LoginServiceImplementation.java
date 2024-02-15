package com.ty.TrackYantra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dao.LoginDao;
import com.ty.TrackYantra.dao.ReportingManagerDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Login;
import com.ty.TrackYantra.dto.ResponseStructure;

@Service
public class LoginServiceImplementation implements LoginService{
    
	
	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private ReportingManagerDao managerDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Login>> saveLogin(Login login) {
		ResponseStructure<Login> structure=new ResponseStructure<>();
		if(Designation.ADMIN==login.getDesignation()) {
			Admin admin=adminDao.getAdminByEmailAndPassword(login.getEmail(), login.getPassword());
			if(admin!=null) {
				Login login1=loginDao.saveLogin(login);
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("login saved successfully");
				structure.setData(login1);
				
				return new ResponseEntity<ResponseStructure<Login>>(structure,HttpStatus.CREATED);
			}
		}
		
		
	}

}
