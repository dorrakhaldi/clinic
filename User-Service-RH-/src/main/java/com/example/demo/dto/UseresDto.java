package com.example.demo.dto;

import java.sql.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

import com.example.demo.models.Roles;

public class UseresDto {

  private String nom;
  private String prenom;
  @Email
  private String email;
  private String cin;
  private Long phoneNumber;
  private Boolean emailConfirmed;
  private Timestamp dateNaissance;
  private String adresse;
  private String gender;
  private Timestamp dateEmploi;
  private String matricule;
  private Boolean etatCompte;
  @Enumerated(EnumType.STRING)
  private Roles roles;

}
