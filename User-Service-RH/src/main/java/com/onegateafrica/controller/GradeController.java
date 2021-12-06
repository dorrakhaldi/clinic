package com.onegateafrica.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onegateafrica.dto.GradeDto;
import com.onegateafrica.entity.Grade;
import com.onegateafrica.service.ServiceGrade;

@RestController
@RequestMapping("/api/grade")
@CrossOrigin("http://localhost:4200/")
public class GradeController {

 private ServiceGrade serviceGrade;

 @Autowired
  public GradeController(ServiceGrade serviceGrade) {
    this.serviceGrade = serviceGrade;
  }

  @GetMapping("/{id}")
  public Grade findById(@PathVariable("id") long id){
    return serviceGrade.getOne(id);
  }
  @GetMapping()
  public List<Grade> findById(){
    return serviceGrade.getAll();
  }

  @PostMapping
  public Grade create(@Valid @RequestBody GradeDto gradeDto ){
    return serviceGrade.create(gradeDto);
  }

  @PutMapping("/{id}")
  public Grade updateGrade(@PathVariable("id") long id , @RequestBody GradeDto gradeDto ){
    return serviceGrade.update(id,gradeDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteGrade(@PathVariable("id") long id){
      return serviceGrade.delete(id);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    // To Return 1 validation error
    //return new ResponseEntity<String>(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    StringBuilder errors = new StringBuilder();
    for (FieldError error : e.getBindingResult().getFieldErrors()) {
      errors.append(error.getField() + ": "+ error.getDefaultMessage()+".\n");
    }
    return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
  }
}
