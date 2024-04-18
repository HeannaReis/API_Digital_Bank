package com.companye.DigitalBank.domain.modules.contas.contapoupanca.service;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities.dto.CriarContaPoupancaDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IContaPoupancaService {
    Conta create (CriarContaPoupancaDTO data);

    Optional<Conta> findByNumeroConta (Long numeroConta);

    Optional<Conta> findById(UUID id);

    List<Conta> getAll();

    Conta update(UUID id, CriarContaCorrenteDTO data);

    String delete (UUID id);

    void adicionarRendimentoEmTodasContas();
}
