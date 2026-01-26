package com.billapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/")  // Matches root URL
    public String home() {
        return "BillApp API is running on port 8082!";
    }
    
    @GetMapping("/test")
    public String test() {
        return "Controller works!";
    }
}
