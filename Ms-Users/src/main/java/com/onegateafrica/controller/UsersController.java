package com.onegateafrica.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onegateafrica.dto.UsersDto;
import com.onegateafrica.entity.Users;
import com.onegateafrica.service.UsersServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/users")
public class UsersController {
  private final UsersServiceImpl usersService;

  public UsersController(UsersServiceImpl usersService) {
    this.usersService = usersService;
  }


  @PostMapping("/createuser")

  public ResponseEntity<Users> createuser(@RequestBody UsersDto c)  {

    try{
      var u= usersService.create(c);
      return new ResponseEntity <>(u, HttpStatus.CREATED);
    }
    catch (Exception e){
      e.getStackTrace();
      return null;
    }
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity <String> deleteuser(@PathVariable("id") long id){
    try{
      usersService.delete(id);
      return new ResponseEntity <>(HttpStatus.OK);}
    catch (Exception e){
      return null;
    }

  }
  @GetMapping("/user/getuser/{id}")
  public ResponseEntity <Users> getuser (@PathVariable("id") long id) throws EntityNotFoundException {

    var u= usersService.getOne(id);
    return new ResponseEntity <>(u, HttpStatus.OK);


  }

  @GetMapping("/user/getuser")
  public ResponseEntity <List<Users>> getusers ()  {
    try{
     var users= usersService.getAll();
      return new ResponseEntity  <>(users, HttpStatus.OK);}
    catch (Exception e){
      return null;
    }

  }
  @PutMapping("/modifuser/{id}")
  public ResponseEntity<Users> updateCat(
      @PathVariable(value = "id") Long id,
      @RequestBody UsersDto userDto){
    try{
      final var updateduser = usersService.update(id,userDto);
      return ResponseEntity.ok(updateduser);}
    catch (EntityNotFoundException e){
      return null;
    }
  }

}
