package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface ReportingManagerService {
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerEmailById(int reportingManagerId,String adminEmail,String adminPassword , ReportingManager reportingManager);
	
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerById(int reportingManagerId, ReportingManager reportingManager);

    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById (String adminEmail,String adminPassword,int reportingManagerId);
    ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(String adminEmail, String adminPassword, ReportingManager reportingManager);

    ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerPasswordById(int reportingManagerId, String adminEmail, String adminPassword, ReportingManager reportingManager);

     ResponseEntity<ResponseStructure<ReportingManager>> getReportingManagerByEmailAndPassword(String reportingManagerEmail, String reportingManagerPassword);

    ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerLocationByReportingManagerId(int reportingManagerId, int locationId);
}
