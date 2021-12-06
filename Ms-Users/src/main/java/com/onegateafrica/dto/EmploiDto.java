package com.onegateafrica.dto;

import java.sql.Time;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmploiDto {

  private int nombreHeures;
  private int heureSupplementaire;
  private Time heureDebut;
  private Time heureFin;
  private Timestamp dateDebut;
  private Timestamp dateFin;
}
