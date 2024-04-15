package com.companye.DigitalBank.domain.modules.contas.contacorrente.service;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.ClienteServiceImpl;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.ContaCorrente;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.repository.IContaCorrenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContaCorrenteServiceImplService implements IContaCorrenteService {

    private final IContaCorrenteRepository contaCorrenteRepository;
    private final ClienteServiceImpl clienteServiceImpl;
    @Override
    @Transactional
    public Conta create(CriarContaCorrenteDTO data) {
        Conta contaCorrente = new ContaCorrente();

        contaCorrente.setAgencia(data.agencia());
        contaCorrente.setNumeroConta(data.numeroConta());
        contaCorrente.setTipoConta(TipoConta.CORRENTE);
        contaCorrente.setSaldo(data.saldo());

        Cliente cliente = data.cliente();
        if (cliente != null) {
            Optional<Cliente> clienteOptional = clienteServiceImpl.findById(cliente.getId());
            if (clienteOptional.isPresent()) {
                // Se o cliente existe, associe-o à conta corrente
                contaCorrente.setCliente(clienteOptional.get());
            } else {
                // Se o cliente não existe, lance uma exceção ou lide com isso de acordo com sua lógica de negócio
                throw new ClienteNotFoundException("Cliente not found with ID: " + cliente.getId());
            }
        } else {
            // Se o cliente no DTO for nulo, lance uma exceção ou lide com isso de acordo com sua lógica de negócio
            throw new IllegalArgumentException("Cliente is null in the DTO");
        }

        contaCorrente = contaCorrenteRepository.save(contaCorrente);
        return contaCorrente;
    }

    @Override
    public Optional<Conta> findByNumeroConta(Long numeroConta) {
        return Optional.empty();
    }

    @Override
    public Optional<Conta> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Conta> getAll() {
        return null;
    }

    @Override
    public Conta update(UUID id, CriarContaCorrenteDTO data) {
        return null;
    }

    @Override
    public String delete(UUID id) {
        return null;
    }
}
