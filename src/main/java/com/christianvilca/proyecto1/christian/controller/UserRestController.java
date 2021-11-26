package com.christianvilca.proyecto1.christian.controller;

import com.christianvilca.proyecto1.christian.caseuse.CreateUser;
import com.christianvilca.proyecto1.christian.caseuse.DeleteUser;
import com.christianvilca.proyecto1.christian.caseuse.GetUser;
import com.christianvilca.proyecto1.christian.caseuse.UpdateUser;
import com.christianvilca.proyecto1.christian.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @RestController
* - Hereda de la notacion @Controller
* - Permite que los metodos que se creen se formateen con el formato JSON
* */

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }

}
