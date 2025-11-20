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

}

