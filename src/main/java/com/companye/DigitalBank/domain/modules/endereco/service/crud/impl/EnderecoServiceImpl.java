package com.companye.DigitalBank.domain.modules.endereco.service.crud.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companye.DigitalBank.domain.modules.endereco.entities.Endereco;
import com.companye.DigitalBank.domain.modules.endereco.entities.dto.ViaCepEnderecoResponse;
import com.companye.DigitalBank.domain.modules.endereco.repository.IEnderecoRepository;
import com.companye.DigitalBank.domain.modules.endereco.service.crud.IEnderecoService;
import com.companye.DigitalBank.domain.modules.endereco.service.viacep.ViaCepEnderecoRequest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnderecoServiceImpl implements IEnderecoService {

    @Autowired
    private final IEnderecoRepository enderecosRepository;

    @Override
    @Transactional
    public Endereco create(ViaCepEnderecoResponse viaCepData, ViaCepEnderecoRequest clienteData) {
        if (viaCepData == null) {
            throw new RuntimeException("Failed to retrieve address data from ViaCEP");
        }

        // Cria um novo objeto Endereco
        Endereco endereco = new Endereco();
        
        // Define os campos com os dados do serviço ViaCEP
        endereco.setCep(viaCepData.getCep());
        endereco.setLogradouro(viaCepData.getLogradouro());
        endereco.setBairro(viaCepData.getBairro());
        endereco.setLocalidade(viaCepData.getLocalidade());
        endereco.setUf(viaCepData.getUf());

        // Define os campos com os dados fornecidos pelo cliente
        endereco.setNumero(clienteData.getNumero());
        endereco.setComplemento(clienteData.getComplemento());

        try {
            // Salva o endereço no banco de dados
            enderecosRepository.save(endereco);
            System.out.println("Endereço salvo com sucesso!");
            return endereco;
        } catch (Exception e) {
            System.err.println("Erro ao salvar endereço: " + e.getMessage());
            throw e;
        }
    }


    @Override
        public Endereco getById (UUID uuid){
            return null;
        }

        @Override
        public Optional<Endereco> findByCity (String localidade){
            return Optional.empty();
        }

        @Override
        public Optional<Endereco> findById (UUID id){
            return Optional.empty();
        }

        @Override
        public List<Endereco> getAll () {
            return null;
        }

        @Override
        public Endereco update (UUID id, ViaCepEnderecoResponse data){
            return null;
        }

        @Override
        public String delete (UUID id){
            return null;
        }

    }
