package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmploiDto;

import com.example.demo.models.EmploiDeTemps;

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
