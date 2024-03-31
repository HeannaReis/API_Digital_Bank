package com.companye.DigitalBank.domain.modules.clientes.service.impl.validation;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class InvalidEnumValueException extends HttpMessageNotReadableException {
    public InvalidEnumValueException(String message) {
        super(message);
    }
}
