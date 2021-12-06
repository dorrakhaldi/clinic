package com.onegateafrica;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static com.onegateafrica.entity.roles.NURSE;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.onegateafrica.dto.UsersDto;
import com.onegateafrica.entity.Users;
import com.onegateafrica.service.UsersServiceImpl;

@SpringBootTest
class DemoApplicationTests {
  @Autowired
  UsersServiceImpl userService;
  @Test
   void ajout (){
    Timestamp date = new Timestamp(System.currentTimeMillis());
    Timestamp d = new Timestamp(11/12/1999);
    UsersDto u = new UsersDto("salah","hamed", "jkd@zjkl","123456",21365487L,d,"dkjlmdjkmpze","male",date,false,NURSE);
    Users util=userService.create(u);
    assertThat(util).isNotNull();

  }
  @Test
   void Rechercher () {
    Users util=userService.getOne(8L);
    assertThat(util).isNotNull();
  }
  @Test
   void RechercherAll () {
    List<Users> users= userService.getAll();
    assertThat(users).isNotNull();
  }
  @Test
   void Modifier (){
    Timestamp date = new Timestamp(System.currentTimeMillis());
    Timestamp d = new Timestamp(11/12/1999);
    UsersDto u = new UsersDto("salah","hamed", "jkd@zjkl","123456",21365487L,d,"dkjlmdjkmpze","male",date,false,NURSE);

    u.setId(2L);
    Users util= userService.update(u.getId(),u);
    assertThat(util).isNotNull();

  }
  @Test
   void Delete (){
    userService.delete(1L);
    Users util=userService.getOne(1L);
    assertThat(util.getEtatCompte()).isFalse();

  }



}
