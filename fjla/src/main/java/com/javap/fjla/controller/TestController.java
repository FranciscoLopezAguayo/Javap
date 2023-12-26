package com.javap.fjla.controller;


import com.javap.fjla.dto.SaveSalesTransaction;
import com.javap.fjla.dto.SaveUser;
import com.javap.fjla.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TEST")
public class TestController {

    @PostMapping("/transaccion")
    public String guardarTransaccion(@RequestBody SaveSalesTransaction transaccion) {
        System.out.println(" SaveSalesTransaction >>>"+ transaccion.getCustomer2());
        // Tu lógica para guardar la transacción
        return "Transacción guardada exitosamente";
    }


}