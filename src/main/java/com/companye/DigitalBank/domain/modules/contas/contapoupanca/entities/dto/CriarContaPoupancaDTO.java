package com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities.dto;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;

import java.math.BigDecimal;
import java.util.UUID;

public record CriarContaPoupancaDTO(
        String agencia,
        Long numeroConta,
        BigDecimal saldo,
        TipoConta tipoConta,
        UUID clienteId
) {

}
