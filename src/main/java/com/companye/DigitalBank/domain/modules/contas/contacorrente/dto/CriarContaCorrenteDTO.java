package com.companye.DigitalBank.domain.modules.contas.contacorrente.dto;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;

import java.util.UUID;

public record CriarContaCorrenteDTO(
        String agencia,
        Long numeroConta,
        double saldo,
        TipoConta tipoConta,
        UUID clienteId
) {
}
