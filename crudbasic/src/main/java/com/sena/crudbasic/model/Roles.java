package com.sena.crudbasic.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User_Roles> userRoles;

}