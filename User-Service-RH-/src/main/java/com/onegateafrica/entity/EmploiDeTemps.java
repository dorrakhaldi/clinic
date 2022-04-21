package com.onegateafrica.entity;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDeTemps {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int nombreHeures;
  private int heureSupplementaire;
  private Time heureDebut;
  private Time heureFin;
  private Timestamp dateDebut;
  private Timestamp dateFin;


}
