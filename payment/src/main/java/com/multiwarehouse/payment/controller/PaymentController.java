package com.multiwarehouse.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Payment!";
    }

}
