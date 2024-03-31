package com.companye.DigitalBank.domain.modules.endereco.controller;

import com.companye.DigitalBank.domain.modules.endereco.EnderecoRequest;
import com.companye.DigitalBank.domain.modules.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping ("/consulta")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));

    }
}
