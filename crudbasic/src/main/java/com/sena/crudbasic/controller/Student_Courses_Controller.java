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

import com.sena.crudbasic.dto.Course_Categories_Dto;
import com.sena.crudbasic.dto.Student_Courses_Dto;
import com.sena.crudbasic.model.Course_Categories;
import com.sena.crudbasic.model.Student_Courses;
import com.sena.crudbasic.service.Student_Courses_Service;

@RestController
public class Student_Courses_Controller {

@Autowired
private Student_Courses_Service service;

// Guardar una nueva relacion estudiante - curso
@PostMapping("")
    public ResponseEntity<Object>save(
            @RequestBody Student_Courses_Dto student_Courses_Dto){
        service.save(student_Courses_Dto);
        return new ResponseEntity<Object>
        ("Se guardó exitosamente",HttpStatus.OK);
    }

// Buscar todas las relaciones estudiante-curso
@GetMapping("")
    public ResponseEntity<Object>findAll(){
    return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK);
    }

// Buscar relacion estudiante-curso por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
        (@PathVariable int id){
        Student_Courses student_Courses=service.findById(id);
        return new ResponseEntity<Object>
        (student_Courses,HttpStatus.OK);
        
}

// Eliminar una relacion estudiante-curso por ID
@DeleteMapping("{id}")
    public ResponseEntity<Object>delete(
            @PathVariable int id){
        service.delete(id);
        return new ResponseEntity<Object>
        ("Se eliminó exitosamente",HttpStatus.OK);
    }


}

