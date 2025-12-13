package com.example.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;      // nome real (ex: Dr. João)

    @Column(nullable = false, unique = true)
    private String username;  // login

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // MEDICO, PACIENTE

    public Usuario() {}

    public Usuario(String nome, String username, String password, String role) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
