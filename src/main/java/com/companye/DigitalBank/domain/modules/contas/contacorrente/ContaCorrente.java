package com.companye.DigitalBank.domain.modules.contas.contacorrente;

import com.companye.DigitalBank.domain.modules.contas.contabase.ContaBase;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_CORRENTE")
public class ContaCorrente extends ContaBase {

    public Double descontarTaxaMensal(Double taxa){
        return null;
    }
}
