package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.CongeDto;
import com.example.demo.models.Conge;


public interface ServiceConge {

  Conge create(CongeDto entity);
  Conge update(long id, CongeDto entity) ;
  boolean           delete(long id)  ;
  Conge getOne(long id) throws EntityNotFoundException;
  List<Conge> getAll();
}
