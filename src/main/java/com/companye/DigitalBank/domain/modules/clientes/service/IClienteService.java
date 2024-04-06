package com.companye.DigitalBank.domain.modules.clientes.service;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteDTO;
import com.companye.DigitalBank.domain.modules.clientes.entities.dto.ClienteUpdateDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClienteService {
    Cliente create (ClienteDTO data);

    Optional<Cliente> findByCpf (String cpf);
    
    Optional<Cliente> findById(UUID id);

    List<Cliente> getAll();

    Cliente update(UUID id, ClienteUpdateDTO data);

    String delete (UUID id);

}
