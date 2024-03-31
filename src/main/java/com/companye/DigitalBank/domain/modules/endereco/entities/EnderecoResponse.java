package com.companye.DigitalBank.domain.modules.endereco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EnderecoResponse {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
