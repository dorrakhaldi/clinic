package com.onegateafrica.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.onegateafrica.dto.GradeDto;
import com.onegateafrica.entity.Grade;
import com.onegateafrica.repository.GradeRepositoty;

@Service
public class GradeServiceImpl implements ServiceGrade{

  private GradeRepositoty gradeRepositoty;
  private ModelMapper mapper;

  public GradeServiceImpl(GradeRepositoty gradeRepositoty, ModelMapper mapper) {
    this.gradeRepositoty = gradeRepositoty;
    this.mapper = mapper;
  }

  @Override
  public Grade create(GradeDto entity) {
    if(entity == null)
      throw new NoSuchElementException();
    return gradeRepositoty.save(mapper.map(entity,Grade.class));
  }

  @Override
  public Grade update(long id, GradeDto entity) {
    var gradeDb = getOne(id);
    if (entity.getNom()!=null)
      gradeDb.setNom(entity.getNom());
    if (entity.getDatePromotion()!=null)
      gradeDb.setDatePromotion(entity.getDatePromotion());
    return gradeRepositoty.save(gradeDb);
  }

  @Override
  public boolean delete(long id) {
    var grade=gradeRepositoty.findById(id);
    if (grade.isPresent())
    {
      gradeRepositoty.deleteById(id);
      return true;
    }
    throw new NoSuchElementException("Grade doesn't exist");
  }

  @Override
  public Grade getOne(long id) throws EntityNotFoundException {
    return gradeRepositoty.findById(id).orElseThrow(()->new NoSuchElementException("Grade doesn't exist"));
  }

  @Override
  public List<Grade> getAll() {
    return gradeRepositoty.findAll();
  }
}
