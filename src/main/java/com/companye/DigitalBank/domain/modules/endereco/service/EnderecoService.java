package com.companye.DigitalBank.domain.modules.endereco.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.companye.DigitalBank.domain.modules.endereco.EnderecoRequest;
import com.companye.DigitalBank.domain.modules.endereco.entities.EnderecoFeign;
import com.companye.DigitalBank.domain.modules.endereco.entities.EnderecoResponse;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class EnderecoService {
    private final EnderecoFeign enderecoFeign;

    public EnderecoResponse executa(EnderecoRequest request) {
        ResponseEntity<EnderecoResponse> responseEntity = enderecoFeign.buscaEnderecoCep(request.getCep());
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Tratar caso a requisição não tenha sido bem sucedida
            // Por exemplo, lançar uma exceção ou retornar um valor padrão
            return null;
        }
    }
}
