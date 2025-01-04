package com.multiwarehouse.cart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Cart!";
    }

}
