package com.spring.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.cruddemo.model.Company;
import com.spring.cruddemo.service.company.CompanyService;

@Controller
@RequestMapping(path = "companies")
public class CompanyController {

   @Autowired
   private CompanyService companyService;

   @GetMapping
   public String index(Model model) {
      model.addAttribute("companies", companyService.getAllCompanies());
      return "companies/index";
   }

   @GetMapping(path = "/create")
   public String create(Model model) {
      model.addAttribute("company", new Company());
      return "companies/create";
   }

   @PostMapping(path = "/save")
   public String save(Company company) {
      companyService.saveCompany(company);
      return "redirect:/companies";
   }


   @GetMapping(path = "/{id}/edit")
   public String edit(@PathVariable("id") Long id, Model model) {
      model.addAttribute("company", companyService.getCompanyById(id));
      return "companies/edit";
   }

   @PostMapping(path = "/{id}/update")
   public String update(@PathVariable("id") Long id, Company company) {
      companyService.updateCompanyById(id, company);
      return "redirect:/companies";
   }

   @GetMapping(path = "/{id}/delete")
   public String delete(@PathVariable("id") Long id) {
      companyService.deleteCompanyById(id);
      return "redirect:/companies";
   }
}