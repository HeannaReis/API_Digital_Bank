package com.companye.DigitalBank.domain.modules.contas.contacorrente.service.impl;

import com.companye.DigitalBank.domain.modules.clientes.entities.Cliente;
import com.companye.DigitalBank.domain.modules.clientes.entities.TipoCliente;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.ClienteServiceImpl;
import com.companye.DigitalBank.domain.modules.clientes.service.impl.validation.ClienteNotFoundException;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.Conta;
import com.companye.DigitalBank.domain.modules.contas.contabase.entities.TipoConta;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.ContaCorrente;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.entities.dto.CriarContaCorrenteDTO;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.repository.IContaCorrenteRepository;
import com.companye.DigitalBank.domain.modules.contas.contacorrente.service.IContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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

        Optional<Cliente> clienteOptional = clienteServiceImpl.findById(data.clienteId());
        Cliente cliente = clienteOptional.orElseThrow(() -> new ClienteNotFoundException(data.clienteId()));
        contaCorrente.setCliente(cliente);

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


    public void descontarTaxaMensalTodasContas() {
        List<Conta> contasCorrente = contaCorrenteRepository.findAll();

        Map<TipoCliente, BigDecimal> taxaManutencaoMap = Map.of(
                TipoCliente.COMUM, ContaCorrente.TAXA_MANUTENCAO_COMUM,
                TipoCliente.SUPER, ContaCorrente.TAXA_MANUTENCAO_SUPER,
                TipoCliente.PREMIUM, ContaCorrente.TAXA_MANUTENCAO_PREMIUM
        );

        contasCorrente.forEach(conta -> {
            BigDecimal taxaManutencao = taxaManutencaoMap.get(conta.getCliente().getTipoCliente());

            conta.setSaldo(conta.getSaldo().subtract(taxaManutencao));
            contaCorrenteRepository.save(conta);

            System.out.println("Taxa mensal de manutenção de R$ " + taxaManutencao + " descontada com sucesso da conta de " + conta.getCliente().getNome());
        });
    }

}
