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

    // Id
    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }

    // Nota
    public BigDecimal getNota() {
        return nota;
    }
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    // Student
    public Students getStudent() {
        return student;
    }
    public void setStudent(Students student) {
        this.student = student;
    }  
     
    // Course
    public Courses getCourse() {
        return course;
    }
    public void setCourse(Courses course) {
        this.course = course;
    }


}
