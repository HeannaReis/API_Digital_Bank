package com.companye.DigitalBank.domain.modules.clientes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
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

//     public Cliente(){

//     }
//     public Cliente(ClienteDTO clienteDTO) {

//         this.cpf =clienteDTO.cpf();
//         this.nome = clienteDTO.nome();
//         this.dataNascimento = clienteDTO.dataNascimento();
//         this.tipoCliente = clienteDTO.tipoCliente();


// //        try {
// //            this.tipoCliente = TipoCliente.valueOf(clienteDTO.tipoCliente());
// //        } catch (IllegalArgumentException e) {
// //            throw new IllegalArgumentException("TipoCliente inválido: " + clienteDTO.tipoCliente());
// //        }
// //
// //        this.dataCriacao = clienteDTO.dataCriacao();
//     }
}
