package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.GradesDto;
import com.sena.crudbasic.model.Courses;
import com.sena.crudbasic.model.Grades;
import com.sena.crudbasic.service.GradesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class GradesController {

    @Autowired
    private GradesService service;

// Guardar una nueva calificación
@PostMapping("")
public ResponseEntity<Object> save(
        @RequestBody GradesDto gradesDto) {
    service.save(gradesDto);
    return new ResponseEntity<Object>(
            "Calificacion guardada exitosamente", HttpStatus.OK);
        }

// Buscar todas las calificaciones
@GetMapping("")
public ResponseEntity<Object> findAll() {
    return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK);
    }
//Buscar calificacion por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
        (@PathVariable int id){
        Grades grade=service.findById(id);
        return new ResponseEntity<Object>
        (grade,HttpStatus.OK);
}

//Eliminar calificaciones por ID
@DeleteMapping("{id}")
public ResponseEntity<Object>delete(
    @PathVariable int id){
    service.delete(id);
    return new ResponseEntity<Object>
    ("Se Elimino", HttpStatus.OK);
    }

}

