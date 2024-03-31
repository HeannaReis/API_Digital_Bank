package com.companye.DigitalBank.domain.modules.clientes.service.impl.validation;

public class InvalidCpfException extends RuntimeException {
    public InvalidCpfException(String message) {
        super("Check CPF field");
    }
}
