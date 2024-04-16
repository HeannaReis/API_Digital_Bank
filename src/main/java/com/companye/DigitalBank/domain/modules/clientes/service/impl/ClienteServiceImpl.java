package com.companye.DigitalBank.domain.modules.clientes.service.impl;


import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.entities.TipoCliente;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteDTO;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteUpdateDTO;
import com.companye.DigitalBank.domain.modules.clientes.repository.IClienteRepository;
import com.companye.DigitalBank.domain.modules.clientes.service.IClienteService;
import com.companye.DigitalBank.domain.modules.clientes.service.ValidaCpfService;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.CpfAlreadyExistsException;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.InvalidCpfException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clientesRepository;
    private final ValidaCpfService validaCpfService;

    @Override
    @Transactional
    public Cliente create(ClienteDTO data) {
        if (clientesRepository.findByCpf(data.cpf()).isPresent()) {
            throw new CpfAlreadyExistsException("CPF already exists: " + data.cpf());
        }

        validarCpf(data.cpf());

        Cliente cliente = new Cliente();
        cliente.setCpf(data.cpf());
        cliente.setNome(data.nome());
        cliente.setDataNascimento(data.dataNascimento());
        cliente.setTipoCliente(data.tipoCliente());
        cliente = clientesRepository.save(cliente);

        return cliente;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clientesRepository.findAll();
    }

    @Override
    @Transactional
    public Cliente update(UUID id, ClienteUpdateDTO data) {
        validarId(id);
        Cliente cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente not found with ID: " + id));

        validarCpf(data.cpf());

        if (!cliente.getCpf().equals(data.cpf()) && clientesRepository.findByCpf(data.cpf()).isPresent()) {
            throw new CpfAlreadyExistsException("CPF already exists: " + data.cpf());
        }

        cliente.setCpf(data.cpf());
        cliente.setNome(data.nome());
        cliente.setDataNascimento(data.dataNascimento());
        cliente.setTipoCliente(TipoCliente.valueOf(String.valueOf(data.tipoCliente())));

        return clientesRepository.save(cliente);
    }

    @Override
    @Transactional
    public String delete(UUID id) {
        validarId(id);
        Cliente cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente not found with ID: " + id));
        clientesRepository.delete(cliente);
        return "Cliente Successfully Deleted! " + id;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findByCpf(String cpf) {
        return clientesRepository.findByCpf(cpf);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(UUID id) {
        return clientesRepository.findById(id);
    }

    private void validarId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
    public void validarCpf(String cpf) {
        if (!validaCpfService.isValid(cpf)) {
            throw new InvalidCpfException("Invalid CPF: " + cpf);
        }
    }
}
