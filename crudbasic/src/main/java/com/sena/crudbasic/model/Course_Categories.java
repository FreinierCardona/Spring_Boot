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

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Course
    public Courses getCourse() {
        return course;
    }
    public void setCourse(Courses course) {
        this.course = course;
    }

    // Category
    public Categories getCategory() {
        return category;
    }
    public void setCategory(Categories category) {
        this.category = category;
    }



}