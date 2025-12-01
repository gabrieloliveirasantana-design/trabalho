package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/home")
    public String home() {
        return "index"; // retorna home.html do templates
    }

    @GetMapping("/login-paciente")
    public String loginPaciente() {
        return "login-paciente";
    }

    @GetMapping("/login-medico")
    public String loginMedico() {
        return "login-medico";
    }
}