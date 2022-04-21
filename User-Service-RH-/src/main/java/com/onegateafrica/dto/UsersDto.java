package com.onegateafrica.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

import com.onegateafrica.entity.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {

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
  private Roles roles;
  private List<GradeDto> gradeList;
  private List<FormationDto> formationList;
  private long idEmploi;
  private List<CongeDto> congeList;
}
