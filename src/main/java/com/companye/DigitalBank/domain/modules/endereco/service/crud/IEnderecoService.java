package com.companye.DigitalBank.domain.modules.endereco.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.companye.DigitalBank.domain.modules.endereco.entities.Endereco;
import com.companye.DigitalBank.domain.modules.endereco.entities.dto.ViaCepEnderecoResponse;
import com.companye.DigitalBank.domain.modules.endereco.service.viacep.ViaCepEnderecoRequest;

public interface IEnderecoService {
    Endereco create (ViaCepEnderecoResponse data, ViaCepEnderecoRequest enderecoRequest);

    Endereco getById (UUID uuid);

    Optional<Endereco> findByCity (String localidade);

    Optional<Endereco> findById(UUID id);

    List<Endereco> getAll();

    Endereco update(UUID id, ViaCepEnderecoResponse data);

    String delete (UUID id);
}
