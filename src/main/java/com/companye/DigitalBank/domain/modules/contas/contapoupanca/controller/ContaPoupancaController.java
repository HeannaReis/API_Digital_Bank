package com.companye.DigitalBank.domain.modules.contas.contapoupanca.controller;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities.dto.CriarContaPoupancaDTO;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.service.impl.ContaPoupancaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas/contapoupanca")
@Validated
public class ContaPoupancaController {
    @Autowired
    private ContaPoupancaServiceImpl service;

    @PostMapping
    public Conta create(@Valid @RequestBody CriarContaPoupancaDTO data){
        return service.create(data);
    }

    @GetMapping
    public List<Conta> getAll(){
        return service.getAll();
    };

    @PostMapping("/rendimento/todas-contas")
    public String adicionarRendimentoMensalTodasContas() {
        service.adicionarRendimentoMensalTodasContas();
        return "Rendimento adicionado em todas as contas com sucesso.";
    }
}
