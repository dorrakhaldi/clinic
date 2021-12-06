package com.example.demo.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
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
  private roles role;

}
