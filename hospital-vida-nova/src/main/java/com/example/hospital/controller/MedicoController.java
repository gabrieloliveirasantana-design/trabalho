package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicoController {

    @GetMapping("/medico/dashboard")
public String medicoDashboard() {
    return "medico-dashboard";
}

@GetMapping("/cadastro/medico")
public String formMedico(org.springframework.ui.Model model) {
    model.addAttribute("usuario", new com.example.hospital.model.Usuario());
    return "cadastro-medico";
}
}
