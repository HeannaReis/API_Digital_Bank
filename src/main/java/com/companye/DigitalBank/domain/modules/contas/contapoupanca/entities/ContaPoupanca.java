package com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities;

import com.companye.DigitalBank.domain.modules.contas.contabase.ContaBase;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_POUPANCA")
public class ContaPoupanca extends ContaBase {
    protected Double taxaRendimento;

    public Double acrescentarRendimentoMensal(Double taxa   ){
        return null;
    }
}
