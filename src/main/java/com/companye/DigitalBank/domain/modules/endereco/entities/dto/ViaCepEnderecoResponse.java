package com.companye.DigitalBank.domain.modules.endereco.entities.dto;

import lombok.Data;
@Data
public class ViaCepEnderecoResponse {
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
