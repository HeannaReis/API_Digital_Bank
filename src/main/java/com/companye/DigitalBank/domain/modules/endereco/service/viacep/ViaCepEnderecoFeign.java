package com.companye.DigitalBank.domain.modules.endereco.service.viacep;

import com.companye.DigitalBank.domain.modules.endereco.entities.dto.ViaCepEnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url ="https://viacep.com.br/ws/", name="viacep")
public interface ViaCepEnderecoFeign {
    @GetMapping("{cep}/json")
    ResponseEntity<ViaCepEnderecoResponse> buscaEnderecoCep(@PathVariable("cep")String cep);
}
