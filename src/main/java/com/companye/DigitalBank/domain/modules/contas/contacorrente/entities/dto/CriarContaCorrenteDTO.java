package com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;

import java.math.BigDecimal;
import java.util.UUID;

public record CriarContaCorrenteDTO(
        String agencia,
        Long numeroConta,
        BigDecimal saldo,
        TipoConta tipoConta,
        UUID clienteId
) {
}
