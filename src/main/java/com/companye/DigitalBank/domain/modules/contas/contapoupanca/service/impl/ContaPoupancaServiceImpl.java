package com.companye.DigitalBank.domain.modules.contas.contapoupanca.service.impl;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.ClienteServiceImpl;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities.ContaPoupanca;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.entities.dto.CriarContaPoupancaDTO;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.repository.IContaPoupancaRepository;
import com.companye.DigitalBank.domain.modules.contas.contapoupanca.service.IContaPoupancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContaPoupancaServiceImpl implements IContaPoupancaService {

    private final IContaPoupancaRepository contaPoupancaRepository;
    private final ClienteServiceImpl clienteServiceImpl;

    @Override
    @Transactional
    public Conta create(CriarContaPoupancaDTO data) {
        Conta contaPoupanca = new ContaPoupanca();

        contaPoupanca.setAgencia(data.agencia());
        contaPoupanca.setNumeroConta(data.numeroConta());
        contaPoupanca.setTipoConta(TipoConta.POUPANCA);
        contaPoupanca.setSaldo(data.saldo());
        UUID cliente = data.clienteId();
        Optional<Cliente> clienteOptional = clienteServiceImpl.findById(data.clienteId());
        contaPoupanca.setCliente(clienteOptional.get());
        System.out.println(contaPoupanca);
        contaPoupanca = contaPoupancaRepository.save(contaPoupanca);
        System.out.println(contaPoupanca);
        return contaPoupanca;
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
        return contaPoupancaRepository.findAllByTipoConta(TipoConta.POUPANCA);
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
