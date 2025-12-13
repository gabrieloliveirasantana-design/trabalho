package com.example.hospital.repository;

import com.example.hospital.model.Agendamento;
import com.example.hospital.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Método para buscar todos os agendamentos de um médico
    List<Agendamento> findByMedico(Usuario medico);

    // Método para buscar agendamentos de um médico dentro de um intervalo de datas
    List<Agendamento> findByMedicoAndDataBetween(Usuario medico, LocalDate startDate, LocalDate endDate);

    // Método para verificar se existe agendamento para o mesmo médico, data e hora
    boolean existsByMedicoAndDataAndHora(Usuario medico, LocalDate data, LocalTime hora);
}
