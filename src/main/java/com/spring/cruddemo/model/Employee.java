package com.spring.cruddemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String firstName;

   private String lastName;

   private String Email;

   private LocalDate dob;

   // private Timestamp joinDate;

   @ManyToOne
   @JoinColumn(name = "company_id", nullable = false)
   private Company company;


   public Employee() {
   }


   public Employee(String firstName, String lastName, String Email, LocalDate dob, Company company) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.Email = Email;
      this.dob = dob;
      this.company = company;
   }


   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getFullName() {
      return getFirstName()+" "+getLastName();
   }

   public String getEmail() {
      return this.Email;
   }

   public void setEmail(String Email) {
      this.Email = Email;
   }

   public LocalDate getDob() {
      return this.dob;
   }

   public void setDob(LocalDate dob) {
      this.dob = dob;
   }

   public Company getCompany() {
      return this.company;
   }

   public void setCompany(Company company) {
      this.company = company;
   }



   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", firstName='" + getFirstName() + "'" +
         ", lastName='" + getLastName() + "'" +
         ", Email='" + getEmail() + "'" +
         ", dob='" + getDob() + "'" +
         ", company='" + getCompany() + "'" +
         "}";
   }

}