package com.onegateafrica.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

import com.onegateafrica.entity.roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {
  private long id;
  private String nom;
  private String prenom;
  @Email
  private String email;
  private String password;
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
  private List<GradeDto> gradeList;
  private List<FormationDto> formationList;
  private long idEmploi;
  private List<CongeDto> congeList;
  public UsersDto (String nom, String prenom, String email, String cin, Long numphone, Timestamp datenaiss, String address, String genre , Timestamp dateemploi, Boolean etatcompte, roles role) {
    this.nom = nom;
    this.prenom = prenom;
    this.cin=cin;
    this.phoneNumber=numphone;
    this.adresse=address;
    this.gender=genre;
    this.email=email;
    this.dateEmploi = dateemploi;
    this.dateNaissance = datenaiss;
    this.etatCompte=etatcompte;
    this.role=role;}
}

