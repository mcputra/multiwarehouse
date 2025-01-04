package com.multiwarehouse.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Stock!";
    }

}
