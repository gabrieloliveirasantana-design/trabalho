package com.example.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoCalendarioDTO {

    private Long id;
    private String paciente;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoCalendarioDTO(
            Long id,
            String paciente,
            LocalDate data,
            LocalTime hora) {
        this.id = id;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }
}
