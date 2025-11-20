package com.sena.crudbasic.model;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario_roles")
public class User_Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rol")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles role;

}
