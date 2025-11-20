package com.sena.crudbasic.model;


import jakarta.persistence.*;

@Entity
@Table(name = "curso_categorias")
public class Course_Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_cat")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses course;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categories category;

}