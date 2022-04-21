package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.onegateafrica.dto.FormationDto;
import com.onegateafrica.entity.Formation;


public interface ServiceFormation {

  Formation create(FormationDto entity);
  Formation update(long id, FormationDto entity) ;
  boolean           delete(long id)  ;
  Formation getOne(long id) throws EntityNotFoundException;
  List<Formation> getAll();
}
