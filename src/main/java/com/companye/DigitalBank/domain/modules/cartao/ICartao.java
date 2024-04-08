package com.companye.DigitalBank.domain.modules.cartao;

public interface ICartao {
    boolean ativar();

    boolean desativar();

    Cartao emitirCartao();

    Cartao efetuarPagamento();

    Cartao alterarSenha();




}
