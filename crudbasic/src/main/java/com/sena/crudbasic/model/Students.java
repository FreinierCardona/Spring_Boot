package com.sena.crudbasic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_registro")
    private LocalDateTime registerDate;

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Users user;

    @OneToMany(mappedBy = "student")
    private List<Student_Courses> studentCourses;

    @OneToMany(mappedBy = "student")
    private List<Grades> grades;

}