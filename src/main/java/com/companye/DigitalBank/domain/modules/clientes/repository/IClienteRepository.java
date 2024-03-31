package com.companye.DigitalBank.domain.modules.clientes.repository;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface IClienteRepository extends JpaRepository<Cliente, UUID> {
    List<Cliente> findByDataNascimento(LocalDate dataNascimento);
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Optional<Cliente> findByCpf(String cpf);

}
