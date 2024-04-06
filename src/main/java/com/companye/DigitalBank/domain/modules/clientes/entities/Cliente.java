package com.companye.DigitalBank.domain.modules.clientes.entities;

import com.companye.DigitalBank.domain.modules.contas.contabase.ContaBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    
    @Column(unique = true)
    private String cpf;
    
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContaBase> contas;

}
