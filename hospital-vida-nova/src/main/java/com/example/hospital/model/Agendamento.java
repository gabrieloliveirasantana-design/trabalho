package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacienteNome;
    private String medicoNome;
    private LocalDateTime dataHora;
    private String status; // AGENDADO, CANCELADO, REALIZADO
    private String observacoes;

    // getters & setters
}
