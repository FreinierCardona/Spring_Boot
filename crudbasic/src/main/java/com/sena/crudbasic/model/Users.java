package com.sena.crudbasic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique  = true)
    private String password;

    @Column(name = "creado_en")
    private LocalDateTime createdAt;

    // uno a muchos con User_Roles
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<User_Roles> userRoles;

    // uno a muchos con Courses (como instructor)
    @OneToMany(mappedBy = "instructor")
    private List<Courses> courses;

    // uno a uno con Students
    @OneToOne(mappedBy = "user")
    private Students student;

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    // CreatedAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
   
    // UserRoles
    public List<User_Roles> getUserRoles() {
        return userRoles;
    }   
    public void setUserRoles(List<User_Roles> userRoles) {
        this.userRoles = userRoles;
    }
    
    // Courses
    public List<Courses> getCourses() {
        return courses;
    }
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
    
    // Student
    public Students getStudent() {
        return student;
    }   
    public void setStudent(Students student) {
        this.student = student;
    }


}

