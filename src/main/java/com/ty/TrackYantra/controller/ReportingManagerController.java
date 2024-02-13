package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.ReportingManagerService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingManagerController {
    @Autowired
    private ReportingManagerService reportingManagerService;

//    @Operation(description = "Update Reporting Manager",summary = "update reporting manager by id")
//    @ApiResponses(value = {@ApiResponse(description = "Update Reporting Manager",responseCode = "200"),@ApiResponse(description = "Not Updated",responseCode = "404")})
    @PutMapping("/updateReportingManagerById/reportingManagerId/{reportingManagerId}")
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerById(@PathVariable int reportingManagerId, @RequestBody ReportingManager reportingManager){
        return reportingManagerService.updateReportingManagerById(reportingManagerId,reportingManager);
    }

//    @Operation(description = "Delete Reporting Manager",summary = "delete reporting manager by id")
//    @ApiResponses(value = {@ApiResponse(description = "Delete Reporting Manager",responseCode = "200"),@ApiResponse(description = "Not Deleted",responseCode = "404")})
    @DeleteMapping("/deleteReportingManagerById/reportingManagerId/{reportingManagerId}")
    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById(@PathVariable int reportingManagerId){
        return reportingManagerService.deleteReportingManagerById(reportingManagerId);
    }


//    @Operation(description = "Save Reporting Manager",summary = "save reporting manager")
//    @ApiResponses(value = {@ApiResponse(description = "Save Reporting Manager",responseCode = "200"),@ApiResponse(description = "Not Save",responseCode = "400")})
    @PostMapping("/addReportingManager")
    public ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(@RequestBody ReportingManager reportingManager){
        return reportingManagerService.saveReportingManager(reportingManager);
    }
}

