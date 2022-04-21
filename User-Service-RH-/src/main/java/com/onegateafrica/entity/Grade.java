package com.onegateafrica.entity;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.onegateafrica.dto.UsersDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column( nullable = false)
  @Length(max = 30,min = 3)
  private String nom;
  @DateTimeFormat
  private Timestamp datePromotion;
  @Transient
  private List<UsersDto> usersDtos;

  public Grade(@Length(max = 30, min = 3) String nom, Timestamp datePromotion) {
    this.nom = nom;
    this.datePromotion = datePromotion;
  }
}
