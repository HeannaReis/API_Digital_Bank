package com.companye.DigitalBank.domain.modules.endereco.service.viacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.companye.DigitalBank.domain.modules.endereco.entities.dto.ViaCepEnderecoResponse;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ViaCepService {
    @Autowired
    private final ViaCepEnderecoFeign viaCepEnderecoFeign;

    public ViaCepEnderecoResponse executa(ViaCepEnderecoRequest request) {

        ResponseEntity<ViaCepEnderecoResponse> responseEntity = viaCepEnderecoFeign.buscaEnderecoCep(request.getCep());
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            //Implementar Melhor Exeption
            System.out.println("Analisar EnderecoService");
            return null;
        }
    }
}
