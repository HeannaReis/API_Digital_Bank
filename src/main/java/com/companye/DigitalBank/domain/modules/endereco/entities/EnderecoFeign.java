package com.companye.DigitalBank.domain.modules.endereco.entities;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url ="https://viacep.com.br/ws/", name="viacep")
public interface EnderecoFeign {
    @GetMapping("{cep}/json")
    ResponseEntity<EnderecoResponse> buscaEnderecoCep(@PathVariable("cep")String cep);
}
