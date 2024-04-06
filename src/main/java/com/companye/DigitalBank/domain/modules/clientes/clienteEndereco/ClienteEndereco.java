package com.companye.DigitalBank.domain.modules.clientes.clienteEndereco;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.endereco.entities.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "endereco_cliente")
public class ClienteEndereco    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
