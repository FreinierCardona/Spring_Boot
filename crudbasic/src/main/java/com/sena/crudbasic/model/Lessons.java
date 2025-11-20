package com.sena.crudbasic.model;
import jakarta.persistence.*;

@Entity
@Table(name = "lecciones")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses course;

}