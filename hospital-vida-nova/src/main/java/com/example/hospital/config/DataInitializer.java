package com.example.hospital.config;

import com.example.hospital.model.Usuario;
import com.example.hospital.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner criarUsuariosIniciais(UsuarioRepository usuarioRepository,
                                                   PasswordEncoder passwordEncoder) {
        return args -> {

            if (usuarioRepository.count() == 0) {

                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setRole("ADMIN");

                Usuario medico = new Usuario();
                medico.setUsername("medico1");
                medico.setPassword(passwordEncoder.encode("abc123"));
                medico.setRole("MEDICO");

                Usuario paciente = new Usuario();
                paciente.setUsername("paciente1");
                paciente.setPassword(passwordEncoder.encode("pac123"));
                paciente.setRole("PACIENTE");

                usuarioRepository.save(admin);
                usuarioRepository.save(medico);
                usuarioRepository.save(paciente);

                System.out.println("✅ Usuários iniciais criados!");
                System.out.println("-> admin / 123456");
                System.out.println("-> medico1 / abc123");
                System.out.println("-> paciente1 / pac123");
            }
        };
    }
}
