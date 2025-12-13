package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relatorios")
public class Relatorio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;
    private String medicoAutor;
    private LocalDateTime criadoEm;

    // getters & setters
}
