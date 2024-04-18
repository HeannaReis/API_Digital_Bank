    package com.companye.DigitalBank.domain.modules.contas.contabase.entities;

    import com.companye.DigitalBank.domain.modules.cartao.entities.Cartao;
    import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
    import com.companye.DigitalBank.domain.modules.contas.contabase.IConta;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.UUID;

        @Entity
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @Data
        public abstract class Conta implements IConta {

            @Id
            @GeneratedValue(strategy = GenerationType.UUID)
            public UUID id;

            protected String agencia;

            @Column(unique = true)
            private Long numeroConta;

            private BigDecimal saldo;

            @Enumerated(EnumType.STRING)
            @Column(name = "tipoConta")
            private TipoConta tipoConta;

            @CreationTimestamp
            private LocalDateTime dataCriacao;

            @UpdateTimestamp
            private LocalDateTime dataAlteracao;

            @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
            private List<Cartao> cartoes = new ArrayList<>();

            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "cliente_id")
            protected Cliente cliente;

            @Override
            public void exibirSaldo() {
                System.out.println("Saldo: " + saldo);
            }

            @Override
            public void transferirPix(BigDecimal valor, IConta destino) {
                int comparacao = this.saldo.compareTo(valor);

                if (comparacao >= 0) {
                    this.saldo = this.saldo.subtract(valor);

                    BigDecimal saldoDestino = destino.getSaldo();
                    saldoDestino = saldoDestino.add(valor); // Adicionando o valor transferido ao saldo da conta destino
                    destino.setSaldo(BigDecimal.valueOf(saldoDestino.doubleValue())); // Convertendo o saldo de volta para double e definindo na conta destino

                    System.out.println("Transferência realizada com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente para realizar a transferência.");
                }
            }
        }
