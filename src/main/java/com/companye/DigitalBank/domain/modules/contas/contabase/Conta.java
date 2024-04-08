    package com.companye.DigitalBank.domain.modules.contas.contabase;

    import com.companye.DigitalBank.domain.modules.cartao.Cartao;
    import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.UUID;

        @Entity
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        @DiscriminatorColumn(name = "tipoConta", discriminatorType = DiscriminatorType.STRING)
        @Data
        public abstract class Conta implements IConta {

            @Id
            @GeneratedValue(strategy = GenerationType.UUID)
            public UUID id;

            protected String agencia;

            @Column(unique = true)
            private int numeroConta;

            private double saldo;

            @Enumerated(EnumType.STRING)
            @Column(name = "tipoConta", insertable = false, updatable = false)
            private TipoConta tipoConta;

            @CreationTimestamp
            private LocalDateTime dataCriacao;

            @UpdateTimestamp
            private LocalDateTime dataAlteracao;

            @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
            private List<Cartao> cartoes = new ArrayList<>();

            @ManyToOne()
            @JoinColumn(name = "cliente_id")
            protected Cliente cliente;


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
