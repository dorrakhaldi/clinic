package com.onegateafrica.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onegateafrica.config.ConfigMapper;
import com.onegateafrica.dto.UsersDto;
import com.onegateafrica.entity.Users;
import com.onegateafrica.repository.UsersRepository;

@Service
public class UsersServiceImpl implements ServiceUsers{
  ConfigMapper c = new ConfigMapper();
  ModelMapper mapper=c.getModelMapper();

  @Autowired
  private final UsersRepository usersRepository;

  public UsersServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }
/* creation employee

 */
  @Override
  public Users create(UsersDto entity) {
    Users u = mapper.map(entity,Users.class);
    if (u == null){
      throw new NullPointerException("error");
    }
    u.setDateEmploi((new Timestamp(System.currentTimeMillis())));
    return usersRepository.save(u);

  }
/* modifier employee

 */
  @Override
  public Users update(long id, UsersDto entity) {
    Users u = mapper.map(entity,Users.class);
    u.setId(id);
    return usersRepository.save(u);
  }
/* modifier l'etat de compte de l'employee (type boolean ) from active to desactive

 */
  @Override
  public void delete(long id) {
    Users u = usersRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(" Entity not found"));
    u.setEtatCompte(false);
    usersRepository.save(u);
  }
/* retourner un employee selon son id (long)*/
  @Override
  public Users getOne(long id) throws EntityNotFoundException {
    return usersRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(" Entity not found"));
  }

  @Override
  /* retourner liste des employee qui se trouvent dans la base */
  public List<Users> getAll() {
    return usersRepository.findAll();
  }
}

