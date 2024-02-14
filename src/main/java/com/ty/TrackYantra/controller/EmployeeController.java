package com.ty.TrackYantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@RequestBody Employee employee) {
		
		return null;
	}
	
	@PutMapping("/updateemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid,@RequestBody Employee employee) {
		
		return null;
	}
	
	@DeleteMapping("/deleteemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid,@RequestBody Employee employee) {
		
		return null;
	}
	
	@GetMapping("/getemployeebyid/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid) {
		
		return null;
	}
	
	@GetMapping("/getallemployees/adminemail/{adminEmail}/adminpassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees(@PathVariable String adminEmail,@PathVariable String adminPassword) {
		
		return null;
	}
	
	
}
