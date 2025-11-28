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

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    // User
    public Users getUser() {
        return user;
    }   
    public void setUser(Users user) {
        this.user = user;
    }
    
    // Role
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }


}
