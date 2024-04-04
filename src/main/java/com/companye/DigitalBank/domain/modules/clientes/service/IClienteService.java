package com.companye.DigitalBank.domain.modules.clientes.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.companye.DigitalBank.domain.modules.clientes.dto.ClienteDTO;
import com.companye.DigitalBank.domain.modules.clientes.dto.ClienteUpdateDTO;
import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;

public interface IClienteService {
    Cliente create (ClienteDTO data);

    Cliente get (UUID uuid);

    Optional<Cliente> findByCpf (String cpf);
    
    Optional<Cliente> findById(UUID id);

    List<Cliente> getAll();

    Cliente update(UUID id, ClienteUpdateDTO data);

    String delete (UUID id);

}
