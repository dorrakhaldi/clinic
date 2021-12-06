package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EspaceDto;
import com.example.demo.models.Espace;

@Service
public class EspaceServiceImpl implements ServiceEspace{

  @Override
  public Espace create(EspaceDto entity) {
    return null;
  }

  @Override
  public Espace update(long id, EspaceDto entity) {
    return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }

  @Override
  public Espace getOne(long id) throws EntityNotFoundException {
    return null;
  }

  @Override
  public List<Espace> getAll() {
    return null;
  }
}
