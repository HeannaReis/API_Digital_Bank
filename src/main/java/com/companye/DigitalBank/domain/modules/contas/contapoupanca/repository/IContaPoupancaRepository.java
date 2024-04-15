package com.companye.DigitalBank.domain.modules.contas.contapoupanca.repository;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IContaPoupancaRepository extends JpaRepository <Conta, UUID> {
}
