package com.spring.cruddemo.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.cruddemo.model.Company;
import com.spring.cruddemo.model.Employee;
import com.spring.cruddemo.repository.CompanyRepository;
import com.spring.cruddemo.repository.EmployeeRepository;

@Configuration
public class DbSeeder {
    
   @Bean
   CommandLineRunner commandLineRunner(CompanyRepository companyRepository, EmployeeRepository employeeRepository){
         return args -> {
            //create company
            Company company = new Company("Google");

            //save company
            companyRepository.save(company);

            //create list of emplyees
            List<Employee> employees = List.of(
               new Employee("Mustafa", "Gamal", "mustafa@test.com", LocalDate.of(1996, Month.MARCH, 26), company),
               new Employee("Ahmed", "Mohmed", "ahmed@test.com", LocalDate.of(1990, Month.MAY, 25), company)
            ); 
            
            //save employees
            employeeRepository.saveAll(employees);

         };
   }
}