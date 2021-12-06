package com.example.demo.services;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import com.example.demo.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
import com.example.demo.models.Users;

import static java.lang.Math.random;

@Service
public class UsersServiceImpl implements ServiceUsers{
   ModelMapper mapper = new ModelMapper();
   static int n;
  @Autowired
  private final UsersRepository usersRepository;

  public UsersServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Users create(UsersDto entity) {
    Users u = mapper.map(entity,Users.class);
    u.setDateEmploi((new Timestamp(System.currentTimeMillis())));
    u.setMatricule(u.getRole().toString()+ n);
    n ++;
    return usersRepository.save(u);

  }

  @Override
  public Users update(long id, UsersDto entity) {
    Users u = mapper.map(entity,Users.class);
    u.setId(id);
    return usersRepository.save(u);
  }

  @Override
  public boolean delete(long id) {
    usersRepository.deleteById(id);
    return usersRepository.existsById(id);
  }

  @Override
  public Users getOne(long id) throws EntityNotFoundException {
    return usersRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(" Entity not found"));
  }

  @Override
  public List<Users> getAll() {
    return usersRepository.findAll();
  }
}
