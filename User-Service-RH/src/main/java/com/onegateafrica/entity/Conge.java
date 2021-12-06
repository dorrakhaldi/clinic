package com.onegateafrica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.sql.Timestamp;

import com.onegateafrica.dto.UsersDto;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private String typeConge;
    private Boolean confirmationChefService;
    private Boolean confirmationRh;
    private long idUser;
    @Transient
    private UsersDto usersDto;

}
