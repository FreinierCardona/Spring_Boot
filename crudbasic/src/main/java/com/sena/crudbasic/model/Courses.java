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

    // id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // descripcion
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // publicationDate
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    // instructor
    public Users getInstructor() {
        return instructor;
    }
    public void setInstructor(Users instructor) {
        this.instructor = instructor;
    }

    // courseCategories
    public List<Course_Categories> getCourseCategories() {
        return courseCategories;
    }
    public void setCourseCategories(List<Course_Categories> courseCategories) {
        this.courseCategories = courseCategories;
    }

    // lessons
    public List<Lessons> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    // studentCourses
    public List<Student_Courses> getStudentCourses() {
        return studentCourses;
    }
    public void setStudentCourses(List<Student_Courses> studentCourses) {
        this.studentCourses = studentCourses;
    }

    // grades
    public List<Grades> getGrades() {
        return grades;
    }
    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    


}
