package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    // Login principal usado pelo Spring Security
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Apenas páginas visuais (UX)
    @GetMapping("/login/paciente")
    public String loginPaciente() {
        return "login-paciente";
    }

    @GetMapping("/login/medico")
    public String loginMedico() {
        return "login-medico";
    }

}
