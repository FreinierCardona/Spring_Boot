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

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // RegisterDate
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    // User
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
   
    // StudentCourses
    public List<Student_Courses> getStudentCourses() {
        return studentCourses;
    }
    public void setStudentCourses(List<Student_Courses> studentCourses) {
        this.studentCourses = studentCourses;
    }
    
    // Grades
    public List<Grades> getGrades() {
        return grades;
    }
    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }


}