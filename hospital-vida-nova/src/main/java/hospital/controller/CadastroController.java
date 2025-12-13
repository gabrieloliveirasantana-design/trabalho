package com.example.hospital.controller;

import com.example.hospital.model.Usuario;
//import com.example.hospital.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    //private final UsuarioService usuarioService;

    //public CadastroController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario) {
        // role esperada: "ROLE_MEDICO" ou "ROLE_PACIENTE"
        //usuarioService.salvar(usuario);
        // após salvar, redirecione ao login com role (para UX)
        String roleParam = usuario.getRole() != null && usuario.getRole().contains("MEDICO") ? "MEDICO" : "PACIENTE";
        return "redirect:/login?role=" + roleParam;
    }
}