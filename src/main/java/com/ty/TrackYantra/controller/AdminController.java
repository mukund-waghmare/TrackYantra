package com.ty.TrackYantra.controller;

import java.util.List;

import org.apache.commons.logging.Log;

import com.ty.TrackYantra.service.ReportingManagerImplementation;
import com.ty.TrackYantra.service.ReportingManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.AdminService;
import com.ty.TrackYantra.service.AdminServiceImplimentatation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AdminController {


	@Autowired
	AdminService adminServiceObject;

	@PostMapping("/saveAdmin")
	@PostConstruct
	@Operation(description = "save Admin",summary = "Admin saved successfully")
	@ApiResponses(value = {@ApiResponse(description = "Admin saved successfully",responseCode = "201"),@ApiResponse(description = "Admin not saved",responseCode = "404")})
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin() {

		ResponseEntity<ResponseStructure<Admin>> admin = adminServiceObject.getAdminByDesignation(Designation.ADMIN);

		if (admin.getBody().getData() == null) {
			Admin admin1 = new Admin();
			 int id=1;
			 String firstName="James";
             String lastname="Bond";
             String email="James@gmail.com";
             String password="james@123";

             long contact=98521456;
             admin1.setAdminId(id);

			admin1.setAdminFirstName(firstName);
			admin1.setAdminLastName(lastname);
			admin1.setAdminEmail(email);
			admin1.setAdminPassword(password);
			admin1.setAdminContact(contact);
			admin1.setAdminAge(30);
			
			admin1.setDesignation(Designation.ADMIN);
			log.info("Admin Created Successfully");
			return adminServiceObject.saveAdmin(admin1);
		} else {
			log.error("Admin Already Exists");
		}
		return admin;

	}

	@GetMapping("/getAdminByDesignation/adminId/{passedDesignation}")
	@Operation(description = "get Admin By Designation",summary = "Admin Found With Designation")
	@ApiResponses(value =  {@ApiResponse(description = "admin found with designation",responseCode = "201"),@ApiResponse(description = "Admin Does Not Exist For Given Role",responseCode = "404")})
	public ResponseEntity<ResponseStructure<Admin>> getAdminByDesignation(Designation passedDesignation) {
		return adminServiceObject.getAdminByDesignation(passedDesignation);
	}

	@GetMapping("/getAdminById/adminId/{passedId}")
	@Operation(description = "Get Admin By Id",summary = "Admin Found For Given Id")
	@ApiResponses(value =  {@ApiResponse(description = "Admin Found For Given Id",responseCode = "201"),@ApiResponse(description = "Admin Does Not Exist For Given Id",responseCode = "404")})
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int passedId) {
		return adminServiceObject.getAdminById(passedId);
	}

	
	@GetMapping("/getAdminByEmail/adminEmail/{passedEmail}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String passedEmail) {
		return adminServiceObject.getAdminByEmail(passedEmail);
	}

	@GetMapping("/getAllReportingManager")
	public ResponseEntity<ResponseStructure<List<ReportingManager>>> getAllReportingManager() {
		return adminServiceObject.getAllReportingManager();
	}

	@GetMapping("/getEmployeeByReportingManagerID/reportingManagerId/{passedReportingManagerId}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByReportingManagerID(
			int passedReportingManagerId) {
		return adminServiceObject.getEmployeeByReportingManagerID(passedReportingManagerId);

	}

}
