package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FormationDto;
import com.example.demo.models.Formation;

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
