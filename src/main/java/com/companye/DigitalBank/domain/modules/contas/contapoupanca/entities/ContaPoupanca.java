package com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_POUPANCA")
public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO_COMUM = 0.005; // 0.5% ao ano
    private static final double TAXA_RENDIMENTO_SUPER = 0.007; // 0.7% ao ano
    private static final double TAXA_RENDIMENTO_PREMIUM = 0.009; // 0.9% ao ano

    public void calcularRendimentoMensal(Cliente cliente) {
        double taxaRendimento = switch (cliente.getTipoCliente()) {
            case COMUM -> TAXA_RENDIMENTO_COMUM / 12; // Rendimento mensal
            case SUPER -> TAXA_RENDIMENTO_SUPER / 12; // Rendimento mensal
            case PREMIUM -> TAXA_RENDIMENTO_PREMIUM / 12; // Rendimento mensal
        };

        double rendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.println("Rendimento mensal de R$ " + rendimento + " creditado com sucesso.");
    }
}
