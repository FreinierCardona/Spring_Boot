package com.sena.crudbasic.controller;

import com.sena.crudbasic.service.Courses_Categories_Service;
import com.sena.crudbasic.model.Course_Categories;
import com.sena.crudbasic.dto.Course_Categories_Dto;

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
public class Course_Categories_Controller {

@Autowired
private Courses_Categories_Service service;

// Guardar una nueva relacion curso-categoria
@PostMapping("")
    public ResponseEntity<Object>save(
            @RequestBody Course_Categories_Dto courses_categories_dto){
        service.save(courses_categories_dto);
        return new ResponseEntity<Object>
        ("Se guardó exitosamente",HttpStatus.OK);
    }

// Buscar todas las relaciones curso-categoria
@GetMapping("")
    public ResponseEntity<Object>findAll(){
    return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK);
    }

// Buscar relacion curso-categoria por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
        (@PathVariable int id){
        Course_Categories courses_categories=service.findById(id);
        return new ResponseEntity<Object>
        (courses_categories,HttpStatus.OK);
        
}

// Eliminar una relacion curso-categoria por ID
@DeleteMapping("{id}")
    public ResponseEntity<Object>delete(
            @PathVariable int id){
        service.delete(id);
        return new ResponseEntity<Object>
        ("Se eliminó exitosamente",HttpStatus.OK);
    }


}


