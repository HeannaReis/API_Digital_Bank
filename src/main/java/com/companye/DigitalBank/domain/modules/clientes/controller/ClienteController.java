package com.companye.DigitalBank.domain.modules.clientes.controller;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteDTO;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteUpdateDTO;
import com.companye.DigitalBank.domain.modules.clientes.service.IClienteService;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
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
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDTO data) {
        Cliente cliente = service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
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