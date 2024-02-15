package com.ty.TrackYantra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.EmployeeNotFoundException;
import com.ty.TrackYantra.exception.EmployeeNotSaved;
import com.ty.TrackYantra.exception.IdNotFoundException;
import com.ty.TrackYantra.exception.InvalidAdminCredentials;
import com.ty.TrackYantra.exception.InvalidEmployeeCredentialsException;
import com.ty.TrackYantra.exception.NoEmployeesExistException;
import com.ty.TrackYantra.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(String adminEmail,String adminPassword,Employee employee) {
		
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if(admin!=null)
		{
			Employee savedEmployee=employeeDao.saveEmployee(employee);
			
			if(savedEmployee!=null)
			{
				ResponseStructure<Employee> resp= new ResponseStructure<Employee>();
				resp.setMessage("Employee saved successfully");
				resp.setStatusCode(HttpStatus.CREATED.value());
				resp.setData(savedEmployee);
				
				return new ResponseEntity<ResponseStructure<Employee>>(resp,HttpStatus.CREATED);
			}
			else
			{
				//employee not saved exception thrown
				throw new EmployeeNotSaved("unable to save employee");
			}
		}
		else
		{
			//wrongAdmincredentials exception
			throw new InvalidAdminCredentials("invalid admin credentials");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeNameById(String adminEmail,String adminPassword,int eid, Employee employee) {
		
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if(admin!=null)
		{
			Optional<Employee> optionalEmployee =employeeRepository.findById(eid);
			if(optionalEmployee.isPresent()) {
				Employee dbEmployee = optionalEmployee.get();
				dbEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
				dbEmployee.setEmployeeLastName(employee.getEmployeeLastName());
				employeeDao.updateEmployeeById(dbEmployee);
			}else {
				throw new IdNotFoundException("Employee ID not Found");
			}
			return null;
		}
		else
		{
			throw new InvalidAdminCredentials("invalid admin credentials");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(String adminEmail,String adminPassword,int eid, Employee employee) {
		
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if(admin!=null)
		{
			return null;
		}
		else
		{
			//wrongAdmincredentials exception
			throw new InvalidAdminCredentials("invalid admin credentials");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(String adminEmail,String adminPassword,int eid) {
		
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if(admin!=null)
		{
			Employee foundEmployee= employeeDao.getEmployee(eid);
			
			if(foundEmployee!=null)
			{
				ResponseStructure<Employee> resp= new ResponseStructure<Employee>();
				resp.setMessage("Employee with given id found");
				resp.setStatusCode(HttpStatus.OK.value());
				resp.setData(foundEmployee);
				
				return new ResponseEntity<ResponseStructure<Employee>>(resp,HttpStatus.OK);
			}
			else
			{
				//throw employee id not found exception.
				throw new EmployeeNotFoundException("no employee found with given id");
			}
		}
		else
		{
			//exception thrown
			throw new InvalidAdminCredentials("invalid admin credentials");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees(String adminEmail,String adminPassword) {
		
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if(admin!=null)
		{
			List<Employee> employees=employeeDao.getAllEmployee();
			
			if(employees.size()!=0)
			{
				ResponseStructure<List<Employee>> resp= new ResponseStructure<List<Employee>>();
				resp.setMessage("list of all employees fetched");
				resp.setStatusCode(HttpStatus.OK.value());
				resp.setData(employees);
				
				return new ResponseEntity<ResponseStructure<List<Employee>>>(resp,HttpStatus.OK);
			}
			else
			{
				//throw no employees added
				throw new NoEmployeesExistException("no employee exist");
			}
		}
		else
		{
			throw new InvalidAdminCredentials("invalid admin credentials");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmployeeEmailAndEmployeePassword(
			String employeeEmail, String employeePassword) {
		
		Employee employee = employeeDao.findEmployeeByEmployeeEmailAndEmployeePassword(employeeEmail, employeePassword);
		if(employee!=null) {
			ResponseStructure<Employee> resp= new ResponseStructure<Employee>();
			resp.setMessage("list of all employees fetched");
			resp.setStatusCode(HttpStatus.OK.value());
			resp.setData(employee);
			
			return new ResponseEntity<ResponseStructure<Employee>>(resp,HttpStatus.OK);
		}else {
			throw new InvalidEmployeeCredentialsException("Invalid Employee credentials");
		}
		
		
	}

}
