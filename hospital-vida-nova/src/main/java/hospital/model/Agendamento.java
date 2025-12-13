package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* =========================
       RELACIONAMENTOS
       ========================= */

    @ManyToOne(optional = false)
    @JoinColumn(name = "medico_id")
    private Usuario medico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Usuario paciente;

    /* =========================
       DADOS DO AGENDAMENTO
       ========================= */

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(length = 500)
    private String observacoes;

    /* =========================
       GETTERS E SETTERS
       ========================= */

    public Long getId() {
        return id;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
