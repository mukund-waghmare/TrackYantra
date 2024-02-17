package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;

import java.util.List;

public interface CompanyService {
	
	
	
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(String adminEmail,String adminPassword,Company company);


	public ResponseEntity<ResponseStructure<String>> deleteCompanyByCompanyId(String adminEmail,String adminPassword,int passedCompanyId);


    ResponseEntity<ResponseStructure<List<Company>>> getAllCompany(String adminPassword, String adminEmail);

    ResponseEntity<ResponseStructure<Company>> getCompanyById(int companyId, String adminPassword, String adminEmail);

    ResponseEntity<ResponseStructure<Company>> updateCompanyByCompanyId(Company company, String adminPassword, String adminEmail, int companyId);

}
