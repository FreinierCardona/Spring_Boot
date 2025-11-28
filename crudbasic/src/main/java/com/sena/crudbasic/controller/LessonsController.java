package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.dto.LessonsDto;
import com.sena.crudbasic.model.Lessons;
import com.sena.crudbasic.service.LessonsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
public class LessonsController {

@Autowired
private LessonsService service;

// Guardar todas las lecciones
@PostMapping("")
public ResponseEntity<Object> save (
    @RequestBody LessonsDto lessonsDto){
     service.save(lessonsDto);
     return new ResponseEntity<Object>
     ("Se guardo Exitosamente", HttpStatus.OK);
    }

// Buscar todas las lecciones
@GetMapping("")
	public ResponseEntity<Object>findAll(){
	return new ResponseEntity<Object>(
			service.findAll(),HttpStatus.OK);
	}

// buscar lecciones por ID
@GetMapping("{id}")
	public ResponseEntity<Object>findById( 
			@PathVariable int id){
        Lessons lessons=service.findById(id);
		return new ResponseEntity<Object>
		(lessons,HttpStatus.OK);
	}

// buscar lecciones por el titulo
@GetMapping("filterbytitle/{title}")
	public ResponseEntity<Object>filterByName( 
			@PathVariable String title){
		List <Lessons> lessons=service.filterByName(title);
	return new ResponseEntity<Object>
	(lessons,HttpStatus.OK);
	
	}

// eliminar lecciones por ID
@DeleteMapping("{id}")
	public ResponseEntity<Object>delete(
			@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>
		("Se eliminó",HttpStatus.OK);
	}

}






