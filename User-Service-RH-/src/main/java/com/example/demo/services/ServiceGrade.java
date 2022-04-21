package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.GradeDto;
import com.example.demo.models.Grade;

public interface ServiceGrade {
  Grade create(GradeDto entity);
  Grade update(long id, GradeDto entity) ;
  boolean           delete(long id)  ;
  Grade getOne(long id) throws EntityNotFoundException;
  List<Grade> getAll();
}
