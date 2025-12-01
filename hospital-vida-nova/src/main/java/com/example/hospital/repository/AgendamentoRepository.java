package com.example.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Agendamento;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByMedicoNome(String medicoNome);
    List<Agendamento> findByPacienteNome(String pacienteNome);
}
