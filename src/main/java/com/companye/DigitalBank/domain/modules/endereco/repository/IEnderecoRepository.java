package com.companye.DigitalBank.domain.modules.endereco.repository;

import com.companye.DigitalBank.domain.modules.endereco.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEnderecoRepository extends JpaRepository <Endereco, UUID> {

}
