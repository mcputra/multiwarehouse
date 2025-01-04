package com.multiwarehouse.warehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Warehouse!";
    }

}