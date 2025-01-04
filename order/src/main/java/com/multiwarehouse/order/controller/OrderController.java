package com.multiwarehouse.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Order!";
    }

}
