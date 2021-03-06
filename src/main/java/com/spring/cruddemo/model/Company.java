package com.spring.cruddemo.model;

import java.util.Set;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
   @NotBlank(message = "Name is mandatory")
   private String name;

   @OneToMany(mappedBy = "company")
   private Set<Employee> employees;

   public Company() {
   }

   public Company(String name) {
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }


   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", name='" + getName() + "'" +
         "}";
   }


}