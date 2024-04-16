package com.companye.DigitalBank.domain.modules.contas.contacorrente.repository;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IContaCorrenteRepository extends JpaRepository <Conta, UUID>{
    @Query("SELECT c FROM Conta c WHERE c.tipoConta = :tipoConta")
    List<Conta> findAllByTipoConta(TipoConta tipoConta);
}
