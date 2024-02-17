package com.ty.TrackYantra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dao.LoginDao;
import com.ty.TrackYantra.dao.ReportingManagerDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.util.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.Login;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.EmployeeNotFoundException;
import com.ty.TrackYantra.exception.InvalidAdminCredentials;
import com.ty.TrackYantra.exception.ReportingManagerNotFound;

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
				login.setAdmin(admin);
				Login login1=loginDao.saveLogin(login);
				List<Login> logins=admin.getLogins();
				if(logins==null) {
					logins=new ArrayList<>();
				}
				logins.add(login1);
				admin.setLogins(logins);
				adminDao.saveAdmin(admin);
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("login saved successfully");
				structure.setData(login1);
				
				return new ResponseEntity<ResponseStructure<Login>>(structure,HttpStatus.CREATED);
			}
			else {
				throw new InvalidAdminCredentials("invalid credentials");
			}
		}
		else if(Designation.REPORTINGMANAGER==login.getDesignation()) {
			ReportingManager manager=managerDao.getReportingManagerByEmailAndPassword(login.getEmail(), login.getPassword());
			if(manager!=null) {
				login.setManager(manager);
				Login login1=loginDao.saveLogin(login);
				List<Login> logins=manager.getLogins();
				if(logins==null) {
					logins=new ArrayList<>();
				}
				logins.add(login1);
				manager.setLogins(logins);
				managerDao.saveReportingManager(manager);
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("login saved successfully");
				structure.setData(login1);
				
				return new ResponseEntity<ResponseStructure<Login>>(structure,HttpStatus.CREATED);
	
			}
			else {
				throw new ReportingManagerNotFound("invalid credentilas");
			}
		}
		else  {
			Employee employee=employeeDao.findEmployeeByEmployeeEmailAndEmployeePassword(login.getEmail(), login.getPassword());
			if(employee!=null) {
				login.setEmployee(employee);;
				Login login1=loginDao.saveLogin(login);
				List<Login> logins=employee.getLogins();
				if(logins==null) {
					logins=new ArrayList<>();
				}
				logins.add(login1);
				employee.setLogins(logins);
				employeeDao.saveEmployee(employee);
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("login saved successfully");
				structure.setData(login1);
				
				return new ResponseEntity<ResponseStructure<Login>>(structure,HttpStatus.CREATED);
	
			}
			else {
				throw new EmployeeNotFoundException("invalid credentilas");
			}
		}
	}

	

}
