package com.companye.DigitalBank.domain.modules.endereco.entities;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_endereco")
public class Endereco {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String cep;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String uf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente clientes;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;
}
