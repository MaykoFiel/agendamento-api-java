package com.banco.agendamento.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Agendamento Bancário")
                        .version("1.0")
                        .description("Sistema para gestão de horários profissionais.")
                        .contact(new Contact()
                        .name("Mayk Fiel")
                        .email("maykofiel.dev@gmail.com")));
    }



}
