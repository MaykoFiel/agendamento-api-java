package com.banco.agendamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record AppointmentDTO(
        @NotBlank(message = "O nome do profissional é obrigatório")
        String professionalName,

        @NotBlank(message = "O nome do cliente é obrigatório")
        String clientName,

        @NotNull(message = "A data e hora são obrigatórias")
        @Future(message = "A data deve ser no futuro")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dateTime
) {

}