package com.onegateafrica.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onegateafrica.dto.CongeDto;
import com.onegateafrica.dto.EmploiDto;
import com.onegateafrica.dto.FormationDto;
import com.onegateafrica.dto.GradeDto;

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
  private String password;
  private String cin;
  private Long phoneNumber;
  private Boolean emailConfirmed;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Timestamp dateNaissance;
  private String adresse;
  private String gender;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Timestamp dateEmploi;
  private String matricule;
  private Boolean etatCompte;
  @Column
  private Long idconge;
  @Enumerated(EnumType.STRING)
  private roles role;
  @Transient
  private List<GradeDto>gradeDtos;
  @Transient
  private List<FormationDto> formationList;
  @Transient
  private List<EmploiDto> emploiDtoList;
  @Transient
  private CongeDto congeDto;


}
