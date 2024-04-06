package com.companye.DigitalBank.domain.modules.contas.contabase;

public interface IConta {
    double getSaldo();
    void setSaldo(double saldo);
    void exibirSaldo();
    void transferirPix(double valor, IConta destino);
}
