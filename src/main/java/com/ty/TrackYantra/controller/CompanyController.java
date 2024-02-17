package com.ty.TrackYantra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.CompanyService;


@RestController
public class CompanyController {
	
	
	@Autowired
	CompanyService compnayService;
	
	
	
	@PostMapping("/saveCompany/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(@PathVariable String adminEmail,@PathVariable String adminPassword,@RequestBody Company passedCompany)
	{
		System.out.println(passedCompany.getCompanyName()+"============================");
		return compnayService.saveCompanyDetails(adminEmail, adminPassword, passedCompany);
	}
	

	@DeleteMapping("/deleteCompanyByCompanyId/adminEmail/{adminEmail}/adminPassword/{adminPassword}/companyId/{passedCompanyId}")
	public ResponseEntity<ResponseStructure<String>> deleteCompanyByCompanyId(@PathVariable String adminEmail,@PathVariable String adminPassword,@PathVariable int passedCompanyId)
	{
		return compnayService.deleteCompanyByCompanyId(adminEmail, adminPassword, passedCompanyId);
	}

}
