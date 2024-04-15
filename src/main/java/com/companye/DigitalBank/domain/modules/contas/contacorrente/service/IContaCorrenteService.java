package com.companye.DigitalBank.domain.modules.contas.contacorrente.service;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.dto.CriarContaCorrenteDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IContaCorrenteService {
    Conta create (CriarContaCorrenteDTO data);

    Optional<Conta> findByNumeroConta (Long numeroConta);

    Optional<Conta> findById(UUID id);

    List<Conta> getAll();

    Conta update(UUID id, CriarContaCorrenteDTO data);

    String delete (UUID id);

}
