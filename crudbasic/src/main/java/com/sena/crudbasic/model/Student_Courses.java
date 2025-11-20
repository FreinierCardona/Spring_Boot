package com.sena.crudbasic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_cursos")
public class Student_Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_curso")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses course;

}