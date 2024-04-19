package com.companye.DigitalBank.domain.modules.contas.contacorrente.controller;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.service.impl.ContaCorrenteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas/contacorrente")
@Validated
public class ContaCorrenteController {
    @Autowired
    private ContaCorrenteServiceImpl service;

    @PostMapping
    public Conta create(@Valid @RequestBody CriarContaCorrenteDTO data){
        return service.create(data);
    }

    @GetMapping
    public List<Conta> getAll(){
        return service.getAll();
    };

    @PostMapping("/taxa-manutencao/descontar-todas-contas")
    public String descontarTaxaMensalTodasContas(){
        service.descontarTaxaMensalTodasContas();
        return "Taxa Manutenção descontada em todas as Contas Correntes! ";
    }
}
