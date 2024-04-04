package com.companye.DigitalBank.domain.modules.clientes.clienteEndereco.repository;

import com.companye.DigitalBank.domain.modules.clientes.clienteEndereco.ClienteEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, UUID> {

}