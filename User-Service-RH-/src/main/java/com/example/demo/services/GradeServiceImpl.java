package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GradeDto;
import com.example.demo.models.Grade;

@Service
public class GradeServiceImpl implements ServiceGrade{

  @Override
  public Grade create(GradeDto entity) {
    return null;
  }

  @Override
  public Grade update(long id, GradeDto entity) {
    return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }

  @Override
  public Grade getOne(long id) throws EntityNotFoundException {
    return null;
  }

  @Override
  public List<Grade> getAll() {
    return null;
  }
}
