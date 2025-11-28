package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.dto.StudentDto;
import com.sena.crudbasic.model.Students;
import com.sena.crudbasic.service.StudentsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
public class StudentController {

@Autowired
private StudentsService service;

// guardar estudiantes
@PostMapping("")
public ResponseEntity<Object> save(
    @RequestBody StudentDto studentDto){
    service.save(studentDto);
    return new ResponseEntity<Object>("Se guardo exitosamente", HttpStatus.OK);
    }

// buscar todos los estudiantes
@GetMapping("")
	public ResponseEntity<Object>findAll(){
	return new ResponseEntity<Object>(
			service.findAll(),HttpStatus.OK);
	}

// buscar estudiante por ID
@GetMapping("{id}")
	public ResponseEntity<Object>findById( 
			@PathVariable int id){
		Students students=service.findById(id);
		return new ResponseEntity<Object>
		(students,HttpStatus.OK);
	}

// buscar por nombre del estudiante
@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object>filterByName( 
			@PathVariable String name){
		List <Students> students=service.filterByName(name);
	return new ResponseEntity<Object>
	(students,HttpStatus.OK);
	}

// Eliminar estudiante por ID
@DeleteMapping("{id}")
	public ResponseEntity<Object>delete(
			@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>
		("Se elimino el estudiante",HttpStatus.OK);
	}

}
