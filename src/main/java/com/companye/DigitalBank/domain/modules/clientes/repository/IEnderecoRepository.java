package com.companye.DigitalBank.domain.modules.clientes.repository;

import com.companye.DigitalBank.domain.modules.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEnderecoRepository extends JpaRepository <Endereco, UUID> {

}
