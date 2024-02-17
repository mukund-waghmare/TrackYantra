package com.ty.TrackYantra.dao;

import com.ty.TrackYantra.dto.Company;
import com.ty.TrackYantra.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyDao {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompany() {
        List<Company> companyList = companyRepository.findAll();
        if (companyList!=null){
            return companyList;
        }else
            return null;
    }

    public Company findById(int companyId) {
       Optional<Company> optionalCompany = companyRepository.findById(companyId);
       if (optionalCompany.isPresent()){
           Company company = optionalCompany.get();
           return company;
       }else
           return null;
    }

    public Company saveCompany(Company toUpdateCompany) {
        Company company = companyRepository.save(toUpdateCompany);
        return company;
    }
}
