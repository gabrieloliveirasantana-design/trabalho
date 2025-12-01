package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/escolher")
    public String escolher() {
        return "login/escolher";
    }

    @GetMapping("/medico")
    public String loginMedico() {
        return "login/login-medico";
    }

    @GetMapping("/paciente")
    public String loginPaciente() {
        return "login/login-paciente";
    }
}
