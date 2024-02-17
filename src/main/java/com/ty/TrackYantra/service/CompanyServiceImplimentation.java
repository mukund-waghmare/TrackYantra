package com.ty.TrackYantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ty.TrackYantra.exception.CompanyDataNotFound;


@Service
public class CompanyServiceImplimentation implements CompanyService {
	@Autowired
	private CompanyDao companyDaoObject;


	@Autowired
	private AdminDao adminDaoObject;
	
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
			Company companyToDelete=companyDaoObject.findById(passedCompanyId);
			if(companyToDelete!=null)
			{
				boolean deleteResult=companyDaoObject.deleteCompanyByCompanyId(companyToDelete,companyToDelete.getCompanyLocation());
				ResponseStructure<String> responStructure= new ResponseStructure<>();
				responStructure.setData("Comapany With Specified Id : "+passedCompanyId+" Deleted Successfully");
				responStructure.setMessage("Deleted Successfully");
				responStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				
				return new ResponseEntity<ResponseStructure<String>>(responStructure,HttpStatus.ACCEPTED);
			}
			
			throw new CompanyDataNotFound("Company Not Found For Specified Id : "+passedCompanyId);
			// company Not Found Exception
			
		}
		throw new AdminNotFoundException("Invalid Admin Credentials");
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Company>>> getAllCompany(String adminPassword,String adminEmail) {
		Admin admin = adminDaoObject.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			List<Company> companyList = companyDaoObject.getAllCompany();
			if (companyList!=null){
				ResponseStructure<List<Company>> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(companyList);
				responseStructure.setMessage("Success");
				return new ResponseEntity<ResponseStructure<List<Company>>>(responseStructure,HttpStatus.OK);
			}else{
				throw new CompanyDataNotFound("Data Not Found");
			}
		}else
			throw new AdminNotFoundException("Admin Not Found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Company>> getCompanyById(int companyId, String adminPassword, String adminEmail) {
		Admin admin = adminDaoObject.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			Company company = companyDaoObject.findById(companyId);
			if (company!=null){
				ResponseStructure<Company> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(company);
				responseStructure.setMessage("Success");
				return new ResponseEntity<ResponseStructure<Company>>(responseStructure,HttpStatus.OK);
			}else
				throw new CompanyDataNotFound("Company Data not Found");

		}else
			throw new AdminNotFoundException("Admin Not Found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Company>> updateCompanyByCompanyId(Company company, String adminPassword, String adminEmail,int companyId) {
		Admin admin = adminDaoObject.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			Company toUpdateCompany = companyDaoObject.findById(companyId);
			if (toUpdateCompany!=null){
				toUpdateCompany.setCompanyName(company.getCompanyName());
				toUpdateCompany.setCompanyLocation(company.getCompanyLocation());
				Company updateCompany = companyDaoObject.saveCompany(toUpdateCompany);
				ResponseStructure<Company> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(updateCompany);
				responseStructure.setMessage("Success");
				return new ResponseEntity<ResponseStructure<Company>>(responseStructure,HttpStatus.OK);
			}else
				throw new CompanyDataNotFound("Data Not Found");
		}else
			throw new AdminNotFoundException("Admin Not Found");
	}

}
