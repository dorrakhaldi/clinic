package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.UsersDto;
import com.example.demo.models.Users;

public interface ServiceUsers {

  Users create(UsersDto entity);
  Users update(long id, UsersDto entity) ;
  boolean delete(long id)  ;
  Users getOne(long id) throws EntityNotFoundException;
  List<Users> getAll();
}
