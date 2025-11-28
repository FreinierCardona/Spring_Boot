package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.dto.Student_Courses_Dto;
import com.sena.crudbasic.dto.User_Roles_Dto;
import com.sena.crudbasic.model.Student_Courses;
import com.sena.crudbasic.model.User_Roles;
import com.sena.crudbasic.service.User_Roles_Service;

@RestController
public class User_Roles_Controller {

@Autowired
private User_Roles_Service service;

// Guardar una nueva relacion usuario-roles
@PostMapping("")
    public ResponseEntity<Object>save(
            @RequestBody User_Roles_Dto user_Roles_Dto){
        service.save(user_Roles_Dto);
        return new ResponseEntity<Object>
        ("Se guardó exitosamente",HttpStatus.OK);
    }

// Buscar todas las relaciones usuario-roles
@GetMapping("")
    public ResponseEntity<Object>findAll(){
    return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK);
    }

// Buscar relacion usuario-roles por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
        (@PathVariable int id){
        User_Roles user_Roles=service.findById(id);
        return new ResponseEntity<Object>
        (user_Roles,HttpStatus.OK);
        
}

// Eliminar una relacion usuario-roles por ID
@DeleteMapping("{id}")
    public ResponseEntity<Object>delete(
            @PathVariable int id){
        service.delete(id);
        return new ResponseEntity<Object>
        ("Se eliminó exitosamente",HttpStatus.OK);
    }


}


}
