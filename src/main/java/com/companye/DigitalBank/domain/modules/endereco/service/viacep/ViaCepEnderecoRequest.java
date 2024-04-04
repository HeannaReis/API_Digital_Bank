package com.companye.DigitalBank.domain.modules.endereco.service.viacep;

import lombok.Data;

@Data
public class ViaCepEnderecoRequest {

    private String cep;
    private Integer numero;
    private String complemento;
}
