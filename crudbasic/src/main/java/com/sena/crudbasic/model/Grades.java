package com.sena.crudbasic.model;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "calificaciones")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota")
    private BigDecimal nota;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses course;


}
