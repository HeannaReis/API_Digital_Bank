package com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities;

import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContaPoupanca extends Conta {
    public static final BigDecimal TAXA_RENDIMENTO_COMUM = BigDecimal.valueOf(0.005);
    public static final BigDecimal TAXA_RENDIMENTO_SUPER = BigDecimal.valueOf(0.007);
    public static final BigDecimal TAXA_RENDIMENTO_PREMIUM = BigDecimal.valueOf(0.009);
}
