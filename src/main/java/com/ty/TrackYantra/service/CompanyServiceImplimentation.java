package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;

public class CompanyServiceImplimentation implements CompanyService {

	@Override
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(String adminEmail, String adminPassword,
			Company company) {
		// TODO Auto-generated method stub
		return null;
	}

}
