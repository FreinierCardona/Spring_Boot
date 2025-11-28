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

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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