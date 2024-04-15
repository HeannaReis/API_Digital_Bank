package com.companye.DigitalBank.domain.modules.cartao.service;

import com.companye.DigitalBank.domain.modules.cartao.entities.Cartao;

public interface ICartao {
    boolean ativar();

    boolean desativar();

    Cartao emitirCartao();

    Cartao efetuarPagamento();

    Cartao alterarSenha();




}
