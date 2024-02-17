package com.ty.TrackYantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.util.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController
//@RequestMapping("/info")
@Slf4j
@CrossOrigin
public class AdminController {

	@GetMapping
	public String get() {
		return "Hello Mukund here!";
	}

	@Autowired
	AdminService adminServiceObject;

	@PostMapping("/saveAdmin")
	@PostConstruct
	@Operation(description = "save Admin", summary = "Admin saved successfully")
	@ApiResponses(value = { @ApiResponse(description = "Admin saved successfully", responseCode = "201"),
			@ApiResponse(description = "Admin not saved", responseCode = "404") })
	private ResponseEntity<ResponseStructure<Admin>> saveAdmin() {

		ResponseEntity<ResponseStructure<Admin>> admin = adminServiceObject.getAdminByDesignation(Designation.ADMIN);

		if (admin == null) {
			Admin admin1 = new Admin();
			int id = 1;
			String firstName = "James";
			String lastname = "Bond";
			String email = "James@gmail.com";
			String password = "james@123";
			long contact = 98521456;
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
		return null;

	}

	@GetMapping("/getAdminByDesignation/adminEmail/{adminEmail}/adminPassword/{adminPassword}/adminDesignation/{passedDesignation}")
	@Operation(description = "get Admin By Designation", summary = "Admin Found With Designation")
	@ApiResponses(value = { @ApiResponse(description = "admin found with designation", responseCode = "201"),
			@ApiResponse(description = "Admin Does Not Exist For Given Role", responseCode = "404") })
	public ResponseEntity<ResponseStructure<Admin>> getAdminByDesignation(@PathVariable String adminEmail,
			@PathVariable String adminPassword, @PathVariable Designation passedDesignation) {
		return adminServiceObject.getAdminByDesignation(passedDesignation);
	}

	@GetMapping("/getAdminById/adminEmail/{adminEmail}/adminPassword/{adminPassword}/adminId/{passedId}")
	@Operation(description = "Get Admin By Id", summary = "Admin Found For Given Id")
	@ApiResponses(value = { @ApiResponse(description = "Admin Found For Given Id", responseCode = "201"),
			@ApiResponse(description = "Admin Does Not Exist For Given Id", responseCode = "404") })

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable String adminEmail,
			@PathVariable String adminPassword, @PathVariable int passedId) {
		System.out.println("============================Controller====================");

		return adminServiceObject.getAdminById(adminEmail, adminPassword, passedId);
	}

	// to recover password of admin
	@GetMapping("/getAdminByEmail/adminEmail/{passedEmail}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@PathVariable String passedEmail) {
		return adminServiceObject.getAdminByEmail(passedEmail);
	}

	@GetMapping("/getAllReportingManager/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<List<ReportingManager>>> getAllReportingManager(
			@PathVariable String adminEmail, @PathVariable String adminPassword) {
		return adminServiceObject.getAllReportingManager(adminEmail, adminPassword);
	}

	@GetMapping("/getEmployeeByReportingManagerID/adminEmail/{adminEmail}/adminPassword/{adminPassword}/reportingManagerId/{passedReportingManagerId}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByReportingManagerID(
			@PathVariable String adminEmail, @PathVariable String adminPassword,
			@PathVariable int passedReportingManagerId) {
		return adminServiceObject.getEmployeeByReportingManagerID(adminEmail, adminPassword, passedReportingManagerId);

	}

	@PostMapping("saveEmployeeToReportingManagerById/adminEmail/{adminEmail}/adminPassword/{adminPassword}//reportingManagerId/{reportingManagerId}/")
	public ResponseEntity<ResponseStructure<ReportingManager>> saveEmployeeToReportingManagerById(
			@PathVariable String email, @PathVariable String adminPassword, @PathVariable int reportingManagerId,
			@RequestBody Employee passedEmployee) {
		return adminServiceObject.saveEmployeeToReportingManagerById(email, adminPassword, reportingManagerId,
				reportingManagerId);
	}

}
