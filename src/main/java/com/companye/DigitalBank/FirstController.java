package com.companye.DigitalBank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstController {

    @GetMapping
    public String text() {
        return ("Banco Digital em Contrução!");
    }
}
