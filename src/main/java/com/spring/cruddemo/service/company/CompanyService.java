package com.spring.cruddemo.service.company;

import java.util.List;

import com.spring.cruddemo.model.Company;

public interface CompanyService {
   List<Company> getAllCompanies();
   Company getCompanyById(Long id);
   void saveCompany(Company company);
   void updateCompanyById(Long id, Company data);
   void deleteCompanyById(Long id); 
}