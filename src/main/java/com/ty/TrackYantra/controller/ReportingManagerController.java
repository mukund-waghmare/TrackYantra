package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.ReportingManagerImplementation;
import com.ty.TrackYantra.service.ReportingManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ReportingManagerController {
    @Autowired
    private ReportingManagerService reportingManagerService;

    @Operation(description = "Update Reporting Manager Email",summary = "update reporting manager by id")
    @ApiResponses(value = {@ApiResponse(description = "Update Reporting Manager Email",responseCode = "200"),@ApiResponse(description = "Not Updated",responseCode = "404")})
    @PutMapping("/updateReportingManagerEmailById/adminEmail/{adminEmail}/adminPassword/{adminPassword}/reportingManagerId/{reportingManagerId}")
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerEmailById(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int reportingManagerId, @RequestBody ReportingManager reportingManager){
        return reportingManagerService.updateReportingManagerEmailById(reportingManagerId,adminEmail,adminPassword,reportingManager);
    }

    @Operation(description = "Delete Reporting Manager",summary = "delete reporting manager by id")
    @ApiResponses(value = {@ApiResponse(description = "Delete Reporting Manager",responseCode = "200"),@ApiResponse(description = "Not Deleted",responseCode = "404")})
    @DeleteMapping("/deleteReportingManagerById/adminEmail/{adminEmail}/adminPassword/{adminPassword}/reportingManagerId/{reportingManagerId}")
    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int reportingManagerId){
        return reportingManagerService.deleteReportingManagerById(adminEmail,adminPassword,reportingManagerId);
    }


    @Operation(description = "Save Reporting Manager",summary = "save reporting manager")
    @ApiResponses(value = {@ApiResponse(description = "Save Reporting Manager",responseCode = "200"),@ApiResponse(description = "Not Save",responseCode = "400")})
    @PostMapping("/addReportingManager/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(@PathVariable String adminEmail, @PathVariable String adminPassword, @ModelAttribute ReportingManager reportingManager,@RequestParam("image") MultipartFile file) throws IOException {
        return reportingManagerService.saveReportingManager(adminEmail,adminPassword,reportingManager,file);
    }

    @Operation(description = "Update Reporting Manager Password",summary = "update reporting email manager by id")
    @ApiResponses(value = {@ApiResponse(description = "Update Reporting Manager Password",responseCode = "200"),@ApiResponse(description = "Not Updated",responseCode = "404")})
    @PutMapping("/updateReportingManagerPasswordById/adminEmail/{adminEmail}/adminPassword/{adminPassword}/reportingManagerId/{reportingManagerId}")
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerPasswordById(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int reportingManagerId, @RequestBody ReportingManager reportingManager){
        return reportingManagerService.updateReportingManagerPasswordById(reportingManagerId,adminEmail,adminPassword,reportingManager);
    }

    @Operation(description = "Get Reporting Manager by Email And Password",summary = "get reporting email manager by email and password")
    @ApiResponses(value = {@ApiResponse(description = "Get Reporting Manager By Email And Password",responseCode = "200"),@ApiResponse(description = "Not Found",responseCode = "404")})
    @GetMapping("/getReportingManagerByEmailAndPassword/reportingManagerEmail/{reportingManagerEmail}/reportingManagerPassword/{reportingManagerPassword}")
    public ResponseEntity<ResponseStructure<ReportingManager>> getReportingManagerByEmailAndPassword(@PathVariable String reportingManagerEmail,@PathVariable String reportingManagerPassword){
        return reportingManagerService.getReportingManagerByEmailAndPassword(reportingManagerEmail,reportingManagerPassword);
    }
}
