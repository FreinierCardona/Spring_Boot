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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.dto.RolesDto;
import com.sena.crudbasic.model.Roles;
import com.sena.crudbasic.service.RolesService;

@RestController
public class RolesController {

 @Autowired
    private RolesService service;

    // Guardar rol
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody RolesDto roldDto) {
        service.save(roldDto);
        return new ResponseEntity<Object>("El rol se guardo exitosamente", HttpStatus.OK);
    }

    // Buscar todos los roles
    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
        service.findAll(), HttpStatus.OK
         );
    }
    //  Buscar rol por ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Roles rol = service.findById(id);

        if (rol == null) {
            return new ResponseEntity<Object>("Rol no encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(rol, HttpStatus.OK);
    }

    // Buscar rol por nombre
    @GetMapping("/filterbyrol/{rol}")
    public ResponseEntity<Object> findByName(@PathVariable String name) {
        List <Roles> rol = service.findByName(name);

        if (rol == null) {
            return new ResponseEntity<Object>("Rol no encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(rol, HttpStatus.OK);
    }

    // Eliminar rol por ID
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
         service.delete(id);
        return new ResponseEntity<Object>("Se elimino el rol", HttpStatus.OK);
    }
}

