package com.sena.crudbasic.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.model.Categories;
import com.sena.crudbasic.dto.CategoriesDto;
import com.sena.crudbasic.service.CategoriesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
public class CategoriesController {

@Autowired
private CategoriesService service;


//Guarda una nueva categoria
@PostMapping("")
	public ResponseEntity<Object>save(
			@RequestBody CategoriesDto categoriesdto){
		service.save(categoriesdto);
		return new ResponseEntity<Object>
		("Se guardó exitosamente",HttpStatus.OK);
	}

//Busca todas las categorias
@GetMapping("")
	public ResponseEntity<Object>findAll(){
	return new ResponseEntity<Object>(
			service.findAll(),HttpStatus.OK);
	}

//Busca categorias por ID
@GetMapping("{id}")
public ResponseEntity<Object> findById
		(@PathVariable int id){
		Categories categories=service.findById(id);
		return new ResponseEntity<Object>
		(categories,HttpStatus.OK);
		
}

//Filtra categorias por nombre
@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object>filterByName( 
			@PathVariable String name){
		List <Categories> categories=service.filterByName(name);
	return new ResponseEntity<Object>
	(categories,HttpStatus.OK);
	}

//Elimina una categoria por ID
@DeleteMapping("{id}")
	public ResponseEntity<Object>delete(
			@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>
		("Se eliminó",HttpStatus.OK);
	}
}