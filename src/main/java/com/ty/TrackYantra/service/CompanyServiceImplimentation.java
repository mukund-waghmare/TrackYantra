package com.ty.TrackYantra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.CompanyDao;
import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.AdminNotFoundException;

@Service
public class CompanyServiceImplimentation implements CompanyService {
	
	@Autowired
	AdminDao adminDaoObject;
	
	@Autowired
	CompanyDao companyDaoObject;
	
	@Autowired
	LocationDao locationDao;

	@Override
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(String adminEmail, String adminPassword,
			Company company) {
		// TODO Auto-generated method stub
		
		
		Admin admin=adminDaoObject.getAdminByEmailAndPassword(adminEmail, adminPassword);
		if(admin!=null)	
		{
			
			if(company.getCompanyLocation()!=null)
			{
				Location location=company.getCompanyLocation();
				locationDao.saveLocation(location);
				
			}
			
			
				Company savedCompany=companyDaoObject.saveCompany(company);
				
				if(savedCompany!=null)
				{
					ResponseStructure<Company> resposeStructure= new ResponseStructure<>();
					resposeStructure.setData(savedCompany);
					resposeStructure.setMessage("Success");
					resposeStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<ResponseStructure<Company>>(resposeStructure,HttpStatus.ACCEPTED);
				}
			
		}
		throw new AdminNotFoundException("Invalid Admin Credentials");
		
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteCompanyByCompanyId(String adminEmail, String adminPassword,
			int passedCompanyId) {
		// TODO Auto-generated method stub
		
		Admin admin=adminDaoObject.getAdminByEmailAndPassword(adminEmail, adminPassword);
		if(admin!=null)	
		{
			Company companyToDelete=null;
			if(companyToDelete!=null)
			{
				boolean deleteResult=companyDaoObject.deleteCompanyByCopnayId(passedCompanyId);
				ResponseStructure<String> responStructure= new ResponseStructure<>();
				responStructure.setData("Comapany With Specified Id : "+passedCompanyId+" Deleted Successfully");
				responStructure.setMessage("Deleted Successfully");
				responStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				
				return new ResponseEntity<ResponseStructure<String>>(responStructure,HttpStatus.ACCEPTED);
			}
			
			// company Not Found Exception
			
		}
		throw new AdminNotFoundException("Invalid Admin Credentials");
		
	}

}
