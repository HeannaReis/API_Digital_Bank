package com.companye.DigitalBank.domain.modules.clientes.service;

import org.springframework.stereotype.Service;

@Service
public class ValidaCpfService {

    public boolean isValid(String cpf) {
        return cpf != null && cpf.length() <= 11;
    }

        // int[] numbers = new int[11];
        // for (int i = 0; i < 11; i++) {
        //     numbers[i] = Character.getNumericValue(cpf.charAt(i));
        // }

        // int sum = 0;
        // for (int i = 0; i < 9; i++) {
        //     sum += numbers[i] * (10 - i);
        // }

        // int remainder = sum % 11;
        // int expectedDigit1 = (remainder < 2) ? 0 : (11 - remainder);

        // if (numbers[9] != expectedDigit1) {
        //     return false;
        // }

        // sum = 0;
        // for (int i = 0; i < 10; i++) {
        //     sum += numbers[i] * (11 - i);
        // }

        // remainder = sum % 11;
        // int expectedDigit2 = (remainder < 2) ? 0 : (11 - remainder);

        // return numbers[10] == expectedDigit2;
    //}
}