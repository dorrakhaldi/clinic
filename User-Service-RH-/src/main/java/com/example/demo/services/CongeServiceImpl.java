package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CongeDto;
import com.example.demo.models.Conge;

@Service
public class CongeServiceImpl implements ServiceConge{


  @Override
  public Conge create(CongeDto entity) {
    return null;
  }

  @Override
  public Conge update(long id, CongeDto entity) {
    return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }

  @Override
  public Conge getOne(long id) throws EntityNotFoundException {
    return null;
  }

  @Override
  public List<Conge> getAll() {
    return null;
  }
}
