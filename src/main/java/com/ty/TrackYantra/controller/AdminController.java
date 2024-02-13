package com.ty.TrackYantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.AdminServiceImplimentatation;

@RestController
public class AdminController {

	@Autowired
	AdminServiceImplimentatation adminServiceObject;

	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin passedAdmin) {
		return adminServiceObject.saveAdmin(passedAdmin);

	}

	@GetMapping("/getAdminByDesignation/adminId/{passedDesignation}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByDesignation(Designation passedDesignation) {
		return adminServiceObject.getAdminByDesignation(passedDesignation);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int passedId) {
		return adminServiceObject.getAdminById(passedId);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String passedEmail) {
		return adminServiceObject.getAdminByEmail(passedEmail);
	}

	public ResponseEntity<ResponseStructure<List<ReportingManager>>> getAllReportingManager() {
		return adminServiceObject.getAllReportingManager();
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByReportingManagerID(
			int passedReportingManagerId) {
		return adminServiceObject.getEmployeeByReportingManagerID(passedReportingManagerId);
		
	}

}
