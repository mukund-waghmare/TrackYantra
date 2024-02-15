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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Operation(description = "saving employee",summary = "saving employee")
	@ApiResponses(value = {@ApiResponse(description = "employee saved successfully",responseCode = "201"),@ApiResponse(description = "unable to save employee",responseCode = "400")})
	@PostMapping("/saveemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(adminEmail, adminPassword, employee);
	}
	
	@Operation(description = "Update Employee details",summary = "Update Employee details")
	@ApiResponses(value = {@ApiResponse(description = "Employee details updated",responseCode = "200"),@ApiResponse(description = "Employee details Not Updated",responseCode = "400")})
	@PutMapping("/updateemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid,@RequestBody Employee employee) {
		
		
		return employeeService.updateEmployeeNameById(adminEmail, adminPassword, eid, employee);
	}
	
	@Operation(description = "delete Employee",summary = "delete Employee")
	@ApiResponses(value = {@ApiResponse(description = "Employee deleted",responseCode = "200"),@ApiResponse(description = "Employee Not Deleted",responseCode = "400")})
	@DeleteMapping("/deleteemployee/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid,@RequestBody Employee employee) {
		
		return employeeService.deleteEmployee(adminEmail, adminPassword, eid, employee);
	}
	
	@Operation(description = "get Employee by id",summary = "get Employee by id")
	@ApiResponses(value = {@ApiResponse(description = "Employee details fetched successfully",responseCode = "200"),@ApiResponse(description = "Employee not found with given id",responseCode = "400")})
	@GetMapping("/getemployeebyid/adminemail/{adminEmail}/adminpassword/{adminPassword}/employeeid/{eid}")
    public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int eid) {
		
		return employeeService.getEmployeeById(adminEmail, adminPassword, eid);
	}
	
	@Operation(description = "get All Employees",summary = "get All Employees")
	@ApiResponses(value = {@ApiResponse(description = "Employees list fetched successfully",responseCode = "200"),@ApiResponse(description = "No Employees exist",responseCode = "400")})
	@GetMapping("/getallemployees/adminemail/{adminEmail}/adminpassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees(@PathVariable String adminEmail,@PathVariable String adminPassword) {
		
		return employeeService.getAllEmployees(adminEmail, adminPassword);
	}
	
	
}
