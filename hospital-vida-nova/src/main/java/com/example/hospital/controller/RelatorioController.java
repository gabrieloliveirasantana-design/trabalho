package com.example.hospital.controller;

import com.example.hospital.model.Relatorio;
import com.example.hospital.repository.RelatorioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioRepository relatorioRepository;

    public RelatorioController(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", relatorioRepository.findAll());
        return "relatorios/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("relatorio", new Relatorio());
        return "relatorios/form";
    }

    @PostMapping
    public String salvar(Relatorio relatorio) {
        relatorioRepository.save(relatorio);
        return "redirect:/relatorios";
    }
}
