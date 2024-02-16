package com.ty.TrackYantra.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface AdminService {
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin passedAdmin);
	public ResponseEntity<ResponseStructure<Admin>> getAdminByDesignation(Designation passedDesignation);
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int passedId);
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String passedEmail);
	public ResponseEntity<ResponseStructure<List<ReportingManager>>> getAllReportingManager();
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByReportingManagerID(int passedReportingManagerId);
	public ResponseEntity<ResponseStructure<ReportingManager>> saveEmployeeToReportingManagerById(int reportingManagerId, int employeeId);
	
}
