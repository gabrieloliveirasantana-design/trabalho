package com.example.hospital.config;

import com.example.hospital.security.CustomAuthenticationSuccessHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler successHandler;

    // Injeção via construtor (forma recomendada)
    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                // PÁGINAS PÚBLICAS
                .requestMatchers(
                    "/", "/home",
                    "/login", "/login/**",
                    "/css/**", "/js/**", "/images/**", "/webjars/**"
                ).permitAll()

                // CONTROLE POR ROLE
                .requestMatchers("/medico/**").hasRole("MEDICO")
                .requestMatchers("/paciente/**").hasRole("PACIENTE")

                // RESTANTE PROTEGIDO
                .anyRequest().authenticated()
            )

            // LOGIN CUSTOMIZADO
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(successHandler)
                .failureUrl("/login?error")
                .permitAll()
            )

            // LOGOUT
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
