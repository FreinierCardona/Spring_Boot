package com.sena.crudbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crudbasic.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
