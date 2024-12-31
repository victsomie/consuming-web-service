package com.example.consumingwebservice.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping(value = "/")
    public String dummy(){
        return "This is just a test";
    }
}
