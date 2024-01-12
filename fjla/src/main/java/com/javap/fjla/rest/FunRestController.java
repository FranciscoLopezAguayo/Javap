package com.javap.fjla.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
        @GetMapping("/fun")
    public String sayHello(){
            return "Hello world";
        }
}
