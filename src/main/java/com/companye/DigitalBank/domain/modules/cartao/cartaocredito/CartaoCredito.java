package com.companye.DigitalBank.domain.modules.cartao.cartaocredito;

import com.companye.DigitalBank.domain.modules.cartao.entities.Cartao;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARTAO_CREDITO")
public class CartaoCredito extends Cartao {
    private double limiteCredito;
    private double taxaUtilizacao;
    private double totalPagamentos;
    private

    boolean bloquearPagamentos(double totalPagamentos){
        if (totalPagamentos >= limiteCredito){
            desativar();
            System.out.println("Cartao Bloqueado");
            return false;
        }
        return true;
    }
}
