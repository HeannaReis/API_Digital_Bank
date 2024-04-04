package com.companye.DigitalBank.domain.modules.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companye.DigitalBank.domain.modules.endereco.entities.dto.ViaCepEnderecoResponse;
import com.companye.DigitalBank.domain.modules.endereco.service.crud.impl.EnderecoServiceImpl;
import com.companye.DigitalBank.domain.modules.endereco.service.viacep.ViaCepEnderecoRequest;
import com.companye.DigitalBank.domain.modules.endereco.service.viacep.ViaCepService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    @Autowired
    private final ViaCepService viaCepEnderecoService;
    @Autowired
    private final EnderecoServiceImpl enderecoServiceImpl;

    @PostMapping("/consulta")
    public ResponseEntity<ViaCepEnderecoResponse> consultaCep(@RequestBody ViaCepEnderecoRequest enderecoRequest) {
        ResponseEntity<ViaCepEnderecoResponse> response = ResponseEntity.ok(viaCepEnderecoService.executa(enderecoRequest));

        enderecoServiceImpl.create(response.getBody(), enderecoRequest);

        return response;
    }
}

