package com.companye.DigitalBank.domain.modules.contas.contacorrente.repository;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IContaCorrenteRepository extends JpaRepository <Conta, UUID>{
}
