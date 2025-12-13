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
    public CommandLineRunner loadData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (usuarioRepository.count() == 0) {

                Usuario medico = new Usuario(
                        "Dr. Carlos Silva",         // nome
                        "medico1",                  // username
                        passwordEncoder.encode("123"),
                        "MEDICO"
                );
                usuarioRepository.save(medico);

                Usuario paciente = new Usuario(
                        "João Pereira",             // nome
                        "paciente1",                // username
                        passwordEncoder.encode("123"),
                        "PACIENTE"
                );
                usuarioRepository.save(paciente);

                System.out.println("✔ Usuários padrão criados.");
            }
        };
    }
}
