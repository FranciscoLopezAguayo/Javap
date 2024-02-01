package com.javap.fjla.controller;


import com.javap.fjla.dto.SaveSalesTransaction;
import com.javap.fjla.dto.SaveUser;
import com.javap.fjla.persistance.entity.Product;
import com.javap.fjla.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TEST")
public class TestController {
    @GetMapping
    public ResponseEntity<String> obtenerString(){
        return ResponseEntity.ok("STRING DESDE EL BACKEND");
    }

}