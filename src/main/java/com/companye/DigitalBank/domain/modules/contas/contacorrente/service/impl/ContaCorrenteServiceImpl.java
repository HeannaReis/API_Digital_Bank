package com.companye.DigitalBank.domain.modules.contas.contacorrente.service.impl;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.ClienteServiceImpl;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.ContaCorrente;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.repository.IContaCorrenteRepository;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.service.IContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContaCorrenteServiceImpl implements IContaCorrenteService {

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

        UUID cliente = data.clienteId();
        if (cliente != null) {
            Optional<Cliente> clienteOptional = clienteServiceImpl.findById(data.clienteId());
            if (clienteOptional.isPresent()) {
                contaCorrente.setCliente(clienteOptional.get());
            } else {
                throw new ClienteNotFoundException("Cliente not found with ID: " + data.clienteId());
            }
        } else {
            throw new IllegalArgumentException("Cliente is null in the DTO");
        }

        contaCorrente = contaCorrenteRepository.save(contaCorrente);
        System.out.println(contaCorrente);
        return contaCorrente;
    }

    @Override
    @Transactional
    public Optional<Conta> findByNumeroConta(Long numeroConta) {
        return Optional.empty();
    }

    @Override
    public Optional<Conta> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Conta> getAll() {
        return contaCorrenteRepository.findAllByTipoConta(TipoConta.CORRENTE);
    }

    @Override
    public Conta update(UUID id, CriarContaCorrenteDTO data) {
        return null;
    }

    @Override
    public String delete(UUID id) {
        return null;
    }


    public void descontarTaxaMensal(Cliente cliente) {
        List<Conta> contasCorrente = contaCorrenteRepository.findAll();

        BigDecimal taxaManutencao = switch (cliente.getTipoCliente()) {
            case COMUM -> ContaCorrente.TAXA_MANUTENCAO_COMUM.divide(BigDecimal.valueOf(12), RoundingMode.HALF_UP);
            case SUPER -> ContaCorrente.TAXA_MANUTENCAO_SUPER.divide(BigDecimal.valueOf(12), RoundingMode.HALF_UP);
            case PREMIUM -> ContaCorrente.TAXA_MANUTENCAO_PREMIUM.divide(BigDecimal.valueOf(12), RoundingMode.HALF_UP);
        };

        for (Conta contaCorrente : contasCorrente) {
            BigDecimal saldo = new BigDecimal(String.valueOf(contaCorrente.getSaldo()));

            if (saldo.compareTo(taxaManutencao) >= 0) {
                saldo = saldo.subtract(taxaManutencao);
                contaCorrente.setSaldo(BigDecimal.valueOf(saldo.doubleValue()));
                contaCorrenteRepository.save(contaCorrente);
                System.out.println("Taxa mensal de manutenção de R$ " + taxaManutencao + " descontada com sucesso da conta de " + cliente.getNome());
            } else {
                System.out.println("Saldo insuficiente para cobrar a taxa mensal de manutenção da conta de " + cliente.getNome());
            }
        }
    }
}
