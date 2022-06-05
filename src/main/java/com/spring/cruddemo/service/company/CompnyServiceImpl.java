package com.spring.cruddemo.service.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cruddemo.model.Company;
import com.spring.cruddemo.repository.CompanyRepository;

@Service
public class CompnyServiceImpl implements CompanyService {

   @Autowired
   private CompanyRepository companyRepository;

   @Override
   public List<Company> getAllCompanies() {
      return companyRepository.findAll();
   }

   @Override
   public Company getCompanyById(Long id) {
      return findCompany(id);
   }

   @Override
   public void saveCompany(Company company) {
      companyRepository.save(company);
      
   }

   @Override
   public void updateCompanyById(Long id, Company data) {
      Company company = findCompany(id);
      company.setName(data.getName());
      companyRepository.save(company);
   }

   @Override
   public void deleteCompanyById(Long id) {
      Company company = findCompany(id);
      companyRepository.delete(company);
   }

   private Company findCompany(Long id) {
      Optional<Company> cOptional = companyRepository.findById(id);
      if(!cOptional.isPresent()){
         throw new RuntimeException("Company with id : "+id+" not found");
      }
      return cOptional.get();
   }
    
}