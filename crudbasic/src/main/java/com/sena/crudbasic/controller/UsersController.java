package com.sena.crudbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.dto.StudentDto;
import com.sena.crudbasic.dto.UsersDto;
import com.sena.crudbasic.model.Students;
import com.sena.crudbasic.model.Users;
import com.sena.crudbasic.service.UsersService;

@RestController
public class UsersController {

@Autowired
private UsersService service;


// guardar usuarios
@PostMapping("")
public ResponseEntity<Object> save(
    @RequestBody UsersDto usersDto){
    service.save(usersDto);
    return new ResponseEntity<Object>("Se guardo exitosamente", HttpStatus.OK);
    }

// buscar todos los usuarios
@GetMapping("")
	public ResponseEntity<Object>findAll(){
	return new ResponseEntity<Object>(
			service.findAll(),HttpStatus.OK);
	}

// buscar usuarios por ID
@GetMapping("{id}")
	public ResponseEntity<Object>findById( 
			@PathVariable int id){
		Users users =service.findById(id);
		return new ResponseEntity<Object>
		(users,HttpStatus.OK);
	}

// buscar por nombre del usuario
@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object>filterByName( 
			@PathVariable String name){
		List <Users> users=service.filterByName(name);
	return new ResponseEntity<Object>
	(users,HttpStatus.OK);
	}

// Eliminar usuario por ID
@DeleteMapping("{id}")
	public ResponseEntity<Object>delete(
			@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>
		("Se elimino el estudiante",HttpStatus.OK);
	}

}


