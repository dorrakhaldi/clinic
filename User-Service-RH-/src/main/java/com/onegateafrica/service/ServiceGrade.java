package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.onegateafrica.dto.GradeDto;
import com.onegateafrica.entity.Grade;

public interface ServiceGrade {
  Grade create(GradeDto entity);
  Grade update(long id, GradeDto entity) ;
  boolean           delete(long id)  ;
  Grade getOne(long id) throws EntityNotFoundException;
  List<Grade> getAll();
}
