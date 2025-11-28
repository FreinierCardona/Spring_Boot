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

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    // Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // UserRoles
    public List<User_Roles> getUserRoles() {
        return userRoles;
    }
    public void setUserRoles(List<User_Roles> userRoles) {
        this.userRoles = userRoles;
    }
    

}