package com.companye.DigitalBank.domain.modules.contas.contabase;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoConta", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class ContaBase implements IConta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(unique = true, insertable = false, updatable = false)
    private int numeroConta;

    private double saldo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoConta", insertable = false, updatable = false)
    private TipoConta tipoConta;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    @Override
    public void transferirPix(double valor, IConta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.setSaldo(destino.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
}
