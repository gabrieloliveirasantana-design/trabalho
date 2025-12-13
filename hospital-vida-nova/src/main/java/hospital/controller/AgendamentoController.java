package com.example.hospital.controller;

import com.example.hospital.dto.AgendamentoCalendarioDTO;
import com.example.hospital.service.AgendamentoService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/medico")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/home")
    public String dashboardMedico(Model model, Authentication authentication) {

        String username = authentication.getName();

        List<AgendamentoCalendarioDTO> agendaSemanal =
                agendamentoService.listarAgendaSemanalDoMedico(username);

        model.addAttribute("agenda", agendaSemanal);

        return "medico-dashboard";
    }
}
