package com.companye.DigitalBank.domain.modules.contas.contacorrente.dto;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;

public record CriarContaCorrenteDTO(
        String agencia,
        Long numeroConta,
        double saldo,
        TipoConta tipoConta,
        Cliente cliente
) {
}
