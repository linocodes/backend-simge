package br.gov.mg.meioambiente.simge.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Person {
  private String firstName;
  private String lastName;
  private boolean employed;
  private LocalDate dob;
  
}