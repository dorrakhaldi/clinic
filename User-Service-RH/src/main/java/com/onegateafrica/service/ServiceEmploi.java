package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.onegateafrica.dto.EmploiDto;
import com.onegateafrica.entity.EmploiDeTemps;

public interface ServiceEmploi {

  EmploiDeTemps create(EmploiDto entity);
  EmploiDeTemps update(long id, EmploiDto entity) ;
  boolean           delete(long id)  ;
  EmploiDeTemps getOne(long id) throws EntityNotFoundException;
  List<EmploiDeTemps> getAll();
}
