package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface ReportingManagerService {
	
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerById(int reportingManagerId, ReportingManager reportingManager);

    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById (int reportingManagerId);

    ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(ReportingManager reportingManager);
}
