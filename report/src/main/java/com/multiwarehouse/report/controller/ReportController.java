package com.multiwarehouse.report.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Report!";
    }

}
