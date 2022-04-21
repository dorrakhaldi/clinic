package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EmploiDto;
import com.example.demo.models.EmploiDeTemps;

public interface ServiceEmploi {

  EmploiDeTemps create(EmploiDto entity);
  EmploiDeTemps update(long id, EmploiDto entity) ;
  boolean           delete(long id)  ;
  EmploiDeTemps getOne(long id) throws EntityNotFoundException;
  List<EmploiDeTemps> getAll();
}
