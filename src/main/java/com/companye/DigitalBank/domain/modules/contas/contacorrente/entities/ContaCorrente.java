package com.companye.DigitalBank.domain.modules.contas.contacorrente.entities;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.contas.contabase.Conta;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_CORRENTE")
public class ContaCorrente extends Conta {
    private static final double TAXA_MANUTENCAO_COMUM = 12.0;
    private static final double TAXA_MANUTENCAO_SUPER = 8.0;
    private static final double TAXA_MANUTENCAO_PREMIUM = 0.0;

    public void descontarTaxaMensal(Cliente cliente) {
        double taxa = switch (cliente.getTipoCliente()) {
            case COMUM -> TAXA_MANUTENCAO_COMUM;
            case SUPER -> TAXA_MANUTENCAO_SUPER;
            case PREMIUM -> TAXA_MANUTENCAO_PREMIUM;
        };

        if (getSaldo() >= taxa) {
            setSaldo(getSaldo() - taxa);
            System.out.println("Taxa mensal de manutenção de R$ " + taxa + " descontada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para cobrar a taxa mensal de manutenção.");
        }
    }
}
