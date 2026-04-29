package com.banco.agendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desabilita para permitir testes via Postman/Swagger
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Libera documentação
                        .anyRequest().authenticated() // Bloqueia o resto
                )
                .httpBasic(basic -> {}) // Ativa o login básico
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Criando um usuário fixo para facilitar seus testes
        UserDetails admin = User.builder()
                .username("banco_admin")
                .password("{noop}senha123") // {noop} indica que a senha não está criptografada (apenas para teste!)
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}