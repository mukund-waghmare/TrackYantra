package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface ReportingManagerService {
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerEmailById(int reportingManagerId,String adminEmail,String adminPassword , ReportingManager reportingManager);

    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById (String adminEmail,String adminPassword,int reportingManagerId);

    ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(String adminEmail,String adminPassword,ReportingManager reportingManager);

    ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerPasswordById(int reportingManagerId, String adminEmail, String adminPassword, ReportingManager reportingManager);
}
