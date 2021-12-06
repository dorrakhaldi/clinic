package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EspaceDto;
import com.example.demo.models.Espace;

public interface ServiceEspace {
  Espace create(EspaceDto entity);
  Espace update(long id, EspaceDto entity) ;
  boolean           delete(long id)  ;
  Espace getOne(long id) throws EntityNotFoundException;
  List<Espace> getAll();

}
