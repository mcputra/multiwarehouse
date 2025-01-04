package com.multiwarehouse.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Product!";
    }

}
