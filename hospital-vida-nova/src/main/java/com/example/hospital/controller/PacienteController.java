package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PacienteController {

    @GetMapping("/paciente/dashboard")
    public String pacienteDashboard() {
        return "pacienteDashboard";
    }

    @GetMapping("/cadastro/paciente")
    public String formPaciente(org.springframework.ui.Model model) {
        model.addAttribute("usuario", new com.example.hospital.model.Usuario());
        return "cadastroPaciente";
    }
}
