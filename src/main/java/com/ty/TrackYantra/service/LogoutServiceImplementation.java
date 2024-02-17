package com.ty.TrackYantra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dao.LogoutDao;
import com.ty.TrackYantra.dao.ReportingManagerDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.Login;
import com.ty.TrackYantra.dto.Logout;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.EmployeeNotFoundException;
import com.ty.TrackYantra.exception.InvalidAdminCredentials;
import com.ty.TrackYantra.exception.ReportingManagerNotFound;
import com.ty.TrackYantra.repository.LogoutRepository;

@Service
public class LogoutServiceImplementation implements LogoutService
{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private LogoutDao logoutDao ;
	
	@Autowired
	private ReportingManagerDao managerDao;
	
	@Autowired 
	private EmployeeDao employeeDao;

	@Override
	public ResponseEntity<ResponseStructure<Logout>> saveLogout(Logout logout) {
		ResponseStructure<Logout> responseStructure = new  ResponseStructure<>();
		if(Designation.ADMIN == logout.getDesignation())
		{
			Admin admin = adminDao.getAdminByEmailAndPassword(logout.getLogoutEmail(), logout.getLogoutPassword());
			if(admin != null)
			{
				logout.setAdmin(admin);
				Logout logout2 = logoutDao.saveLogout(logout);
				List<Logout> logouts = admin.getLogout();
				if(logouts == null)
				{
					logouts = new ArrayList<>();
				}
				logouts.add(logout2);
				admin.setLogout(logouts);
				adminDao.saveAdmin(admin);
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("logout saved successfully");
				responseStructure.setData(logout2);
				
				return new ResponseEntity<ResponseStructure<Logout>>(responseStructure,HttpStatus.CREATED);
			}else
			{
				throw new InvalidAdminCredentials("Invalid Credetials");
			}
		}else if(Designation.REPORTINGMANAGER==logout.getDesignation()) {
			ReportingManager manager=managerDao.getReportingManagerByEmailAndPassword(logout.getLogoutEmail(), logout.getLogoutPassword());
			if(manager!=null) {
				logout.setManager(manager);
				Logout logout1=logoutDao.saveLogout(logout);
				List<Logout> logouts=manager.getLogouts();
				if(logouts==null) {
					logouts=new ArrayList<>();
				}
				logouts.add(logout1);
				manager.setLogouts(logouts);
				managerDao.saveReportingManager(manager);
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("logout saved successfully");
				responseStructure.setData(logout1);
				
				return new ResponseEntity<ResponseStructure<Logout>>(responseStructure,HttpStatus.CREATED);
	
			}
			else {
				throw new ReportingManagerNotFound("invalid credentilas");
			}
		}else
		{
			Employee employee=employeeDao.findEmployeeByEmployeeEmailAndEmployeePassword(logout.getLogoutEmail(), logout.getLogoutPassword());
			if(employee!=null) {
				logout.setEmployee(employee);;
				Logout logout1=logoutDao.saveLogout(logout);
				List<Logout> logouts=employee.getLogouts();
				if(logouts==null) {
					logouts=new ArrayList<>();
				}
				logouts.add(logout1);
				employee.setLogouts(logouts);
				employeeDao.saveEmployee(employee);
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("logout saved successfully");
				responseStructure.setData(logout1);
				
				return new ResponseEntity<ResponseStructure<Logout>>(responseStructure,HttpStatus.CREATED);
	
			}
			else {
				throw new EmployeeNotFoundException("invalid credentilas");
			}
		}
	}

}
