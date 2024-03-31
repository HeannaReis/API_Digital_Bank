package com.companye.DigitalBank.domain.modules.clientes.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public record ClienteUpdateDTO(

        @NotEmpty(message = "Fill in the fields correctly.")
        UUID id,
        @NotEmpty(message = "Fill in the fields correctly.")
        String cpf,
        @NotEmpty(message = "Fill in the fields correctly.")
        @Size(min = 3, max =50, message = "'${validatedValue}' This field must have between {min} and {max} characters.")
        String nome,
        @NotEmpty(message = "Fill in the fields correctly.")
        LocalDate dataNascimento,
        String tipoCliente
) {

}
