package com.ty.TrackYantra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.repository.CompanyRepository;

@Service
public class CompanyDao {
	
	
	@Autowired
	CompanyRepository companyRepository;
	
	
	public Company saveCompany(Company passedCompany)
	{
	
		return companyRepository.save(passedCompany);
	}

	
	public boolean deleteCompanyByCopnayId(int passedCompanyId)
	{	
		companyRepository.deleteById(passedCompanyId);
		
		return true;
	}
}
