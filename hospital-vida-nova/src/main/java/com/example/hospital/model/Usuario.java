package com.example.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // CPF/CRM/email

    @Column(nullable = false)
    private String password; // bcrypt

    @Column(nullable = false)
    private String role; // ROLE_MEDICO / ROLE_PACIENTE / ROLE_ADMIN

    private String nome;

    // getters / setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
