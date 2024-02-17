package com.ty.TrackYantra.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface EmployeeService {

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(String adminEmail,String adminPassword,Employee employee);
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeNameById(String adminEmail,String adminPassword,int eid,Employee employee);
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(String adminEmail,String adminPassword,int eid,Employee employee);
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(String adminEmail,String adminPassword,int eid);
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees(String adminEmail,String adminPassword);
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmployeeEmailAndEmployeePassword(String employeeEmail, String employeePassword);
	public ResponseEntity<ResponseStructure<Employee>> saveProfilePhoto(int employeeId,MultipartFile multipart);
}
