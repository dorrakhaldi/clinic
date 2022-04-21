package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.onegateafrica.dto.EmploiDto;

import com.onegateafrica.entity.EmploiDeTemps;

@Service
public class EmploiServiceImpl implements ServiceEmploi{

  @Override
  public EmploiDeTemps create(EmploiDto entity) {
    return null;
  }

  @Override
  public EmploiDeTemps update(long id, EmploiDto entity) {
    return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }

  @Override
  public EmploiDeTemps getOne(long id) throws EntityNotFoundException {
    return null;
  }

  @Override
  public List<EmploiDeTemps> getAll() {
    return null;
  }
}
