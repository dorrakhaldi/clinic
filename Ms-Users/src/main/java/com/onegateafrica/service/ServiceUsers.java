package com.onegateafrica.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.onegateafrica.dto.UsersDto;
import com.onegateafrica.entity.Users;

public interface ServiceUsers {

  Users create(UsersDto entity);
  Users update(long id, UsersDto entity) ;
  void  delete(long id)  ;
  Users getOne(long id) throws EntityNotFoundException;
  List<Users> getAll();
}
