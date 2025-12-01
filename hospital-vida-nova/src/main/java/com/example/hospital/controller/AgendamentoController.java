package com.example.hospital.controller;

import com.example.hospital.model.Agendamento;
import com.example.hospital.repository.AgendamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", agendamentoRepository.findAll());
        return "agendamentos/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        return "agendamentos/form";
    }

    @PostMapping
    public String salvar(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
        return "redirect:/agendamentos";
    }
}
