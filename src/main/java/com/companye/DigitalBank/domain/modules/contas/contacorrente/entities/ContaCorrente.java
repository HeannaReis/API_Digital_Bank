package com.companye.DigitalBank.domain.modules.contas.contacorrente.entities;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContaCorrente extends Conta {
    public static final BigDecimal TAXA_MANUTENCAO_COMUM = BigDecimal.valueOf(12);
    public static final BigDecimal TAXA_MANUTENCAO_SUPER = BigDecimal.valueOf(8.0);
    public static final BigDecimal TAXA_MANUTENCAO_PREMIUM = BigDecimal.valueOf(0.0);

}
