package com.companye.DigitalBank.domain.modules.cartao;

import com.companye.DigitalBank.domain.modules.contas.contabase.Conta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipoCartao", discriminatorType = DiscriminatorType.STRING)
public abstract class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String numero;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String confirmarSenha;

    private boolean ativo;

    private double limite;

    private TipoCartao tipoCartao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    protected Conta conta;

    public boolean ativar() {
        this.ativo = true;
        return true;
    }

    public boolean desativar() {
        this.ativo = false;
        return true;
    }

    public void ajustarLimite(double novoLimite) {
        this.limite = novoLimite;
    }
}
