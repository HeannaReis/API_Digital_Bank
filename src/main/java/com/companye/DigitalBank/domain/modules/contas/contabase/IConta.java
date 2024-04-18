package com.companye.DigitalBank.domain.modules.contas.contabase;

import java.math.BigDecimal;

public interface IConta {
   public BigDecimal getSaldo();

   void setSaldo(BigDecimal saldo);

    void exibirSaldo();

    void transferirPix(BigDecimal valor, IConta destino);
}
