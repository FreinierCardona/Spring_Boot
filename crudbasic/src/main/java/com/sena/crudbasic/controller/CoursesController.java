package com.sena.crudbasic.controller;

import com.sena.crudbasic.service.CoursesService;
import com.sena.crudbasic.model.Courses;
import com.sena.crudbasic.dto.CoursesDto;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController {

@Autowired
private CoursesService service;

// Guardar un nuevo curso
@PostMapping("")
    public ResponseEntity<Object>save(
            @RequestBody CoursesDto coursesdto){
        service.save(coursesdto);
        return new ResponseEntity<Object>
        ("Se guardó exitosamente",HttpStatus.OK);
    }

// Buscar todos los cursos
@GetMapping("")
    public ResponseEntity<Object>findAll(){
    return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK);
    }

// Buscar curso por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
        (@PathVariable int id){
        Courses courses=service.findById(id);
        return new ResponseEntity<Object>
        (courses,HttpStatus.OK);
}

//Buscar cursos por nombre
@GetMapping("filterbyname/{name}")
    public ResponseEntity<Object>filterByName( 
            @PathVariable String name){
        List <Courses> courses=service.filterByName(name);
    return new ResponseEntity<Object>
    (courses,HttpStatus.OK);
    }

// Eliminar un curso por ID
@DeleteMapping("{id}")
    public ResponseEntity<Object>delete(
            @PathVariable int id){
        service.delete(id);
        return new ResponseEntity<Object>
        ("Se eliminó exitosamente",HttpStatus.OK);
    }


}