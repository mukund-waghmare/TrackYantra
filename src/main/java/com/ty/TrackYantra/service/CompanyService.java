package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface CompanyService {
	
	
	
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(String adminEmail,String adminPassword,Company company);

	public ResponseEntity<ResponseStructure<String>> deleteCompanyByCompanyId(String adminEmail,String adminPassword,int passedCompanyId);

}
