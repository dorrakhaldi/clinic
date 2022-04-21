package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.onegateafrica.dto.FormationDto;
import com.onegateafrica.entity.Formation;

@Service
public class FormationServiceImpl implements ServiceFormation{

  @Override
  public Formation create(FormationDto entity) {
    return null;
  }

  @Override
  public Formation update(long id, FormationDto entity) {
    return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }

  @Override
  public Formation getOne(long id) throws EntityNotFoundException {
    return null;
  }

  @Override
  public List<Formation> getAll() {
    return null;
  }
}
