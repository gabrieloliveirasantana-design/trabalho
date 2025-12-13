package com.example.hospital.security;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {

        String contextPath = request.getContextPath();

        if (hasRole(authentication, "ROLE_MEDICO")) {
            response.sendRedirect(contextPath + "/medico/home");
            return;
        }

        if (hasRole(authentication, "ROLE_PACIENTE")) {
            response.sendRedirect(contextPath + "/paciente/home");
            return;
        }

        // fallback de segurança (não deve acontecer)
        response.sendRedirect(contextPath + "/login?error=role");
    }

    private boolean hasRole(Authentication authentication, String role) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (role.equals(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}
