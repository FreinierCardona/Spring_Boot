package com.sena.crudbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crudbasic.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
