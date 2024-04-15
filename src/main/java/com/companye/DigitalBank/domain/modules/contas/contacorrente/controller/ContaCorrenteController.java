package com.companye.DigitalBank.domain.modules.contas.contacorrente.controller;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.service.IContaCorrenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
@Validated
public class ContaCorrenteController {
    @Autowired
    private IContaCorrenteService service;

    @PostMapping
    public Conta create(@Valid @RequestBody CriarContaCorrenteDTO data){
        return service.create(data);
    }
}
