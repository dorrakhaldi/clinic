package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.FormationDto;
import com.example.demo.models.Formation;


public interface ServiceFormation {

  Formation create(FormationDto entity);
  Formation update(long id, FormationDto entity) ;
  boolean           delete(long id)  ;
  Formation getOne(long id) throws EntityNotFoundException;
  List<Formation> getAll();
}
