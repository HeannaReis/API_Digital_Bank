package com.companye.DigitalBank.domain.modules.clientes.clienteEndereco.dto;

import com.companye.DigitalBank.domain.modules.clientes.entities.TipoCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClienteEnderecoDTO (

        @NotEmpty(message = "CPF must not be empty")
        String cpf,

        @NotBlank(message = "Name must not be blank")
        @Size(min = 3, max =50, message = "'${validatedValue}' This field must have between {min} and {max} characters.")
        String nome,

        @NotNull(message = "Date of birth must not be null")
        LocalDate dataNascimento,
        TipoCliente tipoCliente,
        String cep,
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String localidade,
        String uf){
}
