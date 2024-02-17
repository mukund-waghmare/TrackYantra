package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.CompanyDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.exception.AdminNotFoundException;
import com.ty.TrackYantra.exception.CompanyDataNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImplimentation implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private AdminDao adminDao;
	@Override
	public ResponseEntity<ResponseStructure<Company>> saveCompanyDetails(String adminEmail, String adminPassword,
			Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Company>>> getAllCompany(String adminPassword,String adminEmail) {
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			List<Company> companyList = companyDao.getAllCompany();
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
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			Company company = companyDao.findById(companyId);
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
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null){
			Company toUpdateCompany = companyDao.findById(companyId);
			if (toUpdateCompany!=null){
				toUpdateCompany.setCompanyName(company.getCompanyName());
				toUpdateCompany.setCompanyLocation(company.getCompanyLocation());
				Company updateCompany = companyDao.saveCompany(toUpdateCompany);
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
