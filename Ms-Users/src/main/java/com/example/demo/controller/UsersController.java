package com.example.demo.controller;

import com.example.demo.dto.UsersDto;
import com.example.demo.models.Users;
import com.example.demo.services.UsersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }


    @PostMapping("/user/createuser")

    public ResponseEntity<Users> createuser(@RequestBody UsersDto c)  {
        Users u= usersService.create(c);
        return new ResponseEntity <>(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity <?> deleteuser(@PathVariable("id") long id){
        usersService.delete(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }
    @GetMapping("/user/getuser/{id}")
    public ResponseEntity <Users> getuser (@PathVariable("id") long id) throws EntityNotFoundException {
        Users u= usersService.getOne(id);
        return new ResponseEntity <>(u, HttpStatus.OK);

    }

    @GetMapping("/user/getuser")
    public ResponseEntity <List<Users>> getusers ()  {
        List<Users> users= usersService.getAll();
        return new ResponseEntity  <>(users, HttpStatus.OK);

    }
    @PutMapping("/modifuser/{id}")
    public ResponseEntity<Users> updateCat(
            @PathVariable(value = "id") Long id,
            @RequestBody UsersDto userDto){

        final Users updateduser = usersService.update(id,userDto);
        return ResponseEntity.ok(updateduser);
    }
}


