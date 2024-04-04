package com.companye.DigitalBank.domain.modules.clientes.controller;

import com.companye.DigitalBank.domain.modules.clientes.dto.ClienteDTO;
import com.companye.DigitalBank.domain.modules.clientes.dto.ClienteUpdateDTO;
import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.service.IClienteService;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {
    @Autowired
    private IClienteService service;

    @GetMapping
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody ClienteDTO data) {
        System.out.println(data);
        return service.create(data);
    }

    @PutMapping("/alterar/{id}")
    public Cliente update(@Valid @PathVariable UUID id, @RequestBody ClienteUpdateDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/deletar/{id}")
    public String delete(@PathVariable UUID id) {
        return service.delete(id);

    }

    @GetMapping("/buscarcpf/{cpf}")
    public Cliente findByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente not found with CPF: " + cpf));
    }
    @GetMapping("/buscarid/{id}")
    public Cliente findById(@PathVariable UUID id) {
        return service.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente not found with ID: " + id));
    }

}