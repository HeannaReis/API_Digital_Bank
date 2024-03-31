package com.companye.DigitalBank.domain.modules.clientes.service.impl.validation;

import java.util.UUID;

public class ClienteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String message) {
        super(message);
    }
    public ClienteNotFoundException(UUID id) {
        super("Cliente não encontrado com ID: " + id);
    }
}