package com.example.demo.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Espace {
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String password;
  private String username;
  @OneToMany(mappedBy = "espace", cascade = CascadeType.REMOVE)
  private List<Grade> gradeList;

}
