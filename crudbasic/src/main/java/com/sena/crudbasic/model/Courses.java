package com.sena.crudbasic.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Users instructor;

    @OneToMany(mappedBy = "course")
    private List<Course_Categories> courseCategories;

    @OneToMany(mappedBy = "course")
    private List<Lessons> lessons;

    @OneToMany(mappedBy = "course")
    private List<Student_Courses> studentCourses;

    @OneToMany(mappedBy = "course")
    private List<Grades> grades;

}
