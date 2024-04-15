package com.companye.DigitalBank.domain.modules.cartao.cartaodebito;

import com.companye.DigitalBank.domain.modules.cartao.entities.Cartao;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARTAO_CREDITO")
public class CartaoDebito extends Cartao {
    private Double limiteDiario;
}
