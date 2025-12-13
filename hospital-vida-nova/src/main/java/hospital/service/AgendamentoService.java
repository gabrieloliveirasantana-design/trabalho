package com.example.hospital.service;

import com.example.hospital.dto.AgendamentoCalendarioDTO;
import com.example.hospital.model.Usuario;
import com.example.hospital.repository.AgendamentoRepository;
import com.example.hospital.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository,
                              UsuarioRepository usuarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<AgendamentoCalendarioDTO> listarAgendaSemanalDoMedico(String username) {

        Usuario medico = usuarioRepository.findByUsername(username);
        if (medico == null) {
            return List.of();
        }

        LocalDate hoje = LocalDate.now();
        LocalDate inicio = hoje.with(DayOfWeek.MONDAY);
        LocalDate fim = hoje.with(DayOfWeek.FRIDAY);

        return agendamentoRepository
                .findByMedicoAndDataBetween(medico, inicio, fim)
                .stream()
                .map(a -> new AgendamentoCalendarioDTO(
                        a.getId(),
                        a.getPaciente().getNome(),
                        a.getData(),
                        a.getHora()
                ))
                .toList();
    }
}
