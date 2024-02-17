package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAllCompany/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<List<Company>>> getAllCompany(String adminPassword, String adminEmail){
        return companyService.getAllCompany(adminEmail,adminPassword);
    }

    @GetMapping("/getAllCompanyById/companyId/{companyId}/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<Company>> getCompanyById(int companyId,String adminEmail,String adminPassword){
        return companyService.getCompanyById(companyId,adminPassword,adminEmail);
    }

    @PutMapping("/updateCompanyByCompanyId/companyId/{companyId}/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
    public ResponseEntity<ResponseStructure<Company>> updateCompanyByCompanyId(@RequestBody Company company,String adminEmail,String adminPassword,int companyId ){
        return companyService.updateCompanyByCompanyId(company,adminPassword,adminEmail,companyId);
    }
    
    @DeleteMapping("/deleteCompanyByCompanyId/adminEmail/{adminEmail}/adminPassword/{adminPassword}/companyId/{companyId}")
    public ResponseEntity<ResponseStructure<String>> deleteCompanyByCompanyId(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int companyId)
    {
    	return companyService.deleteCompanyByCompanyId(adminEmail, adminPassword, companyId);
    }
}
