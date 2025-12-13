package com.example.hospital.controller;

import com.example.hospital.model.Usuario;
import com.example.hospital.service.UsuarioService;
import com.example.hospital.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository,
                             UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }

    @GetMapping("/novo")
    public String novoUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios-form"; // template de cadastro
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }
}
