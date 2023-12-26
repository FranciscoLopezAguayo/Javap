package com.javap.fjla.controller;

import com.javap.fjla.dto.RegisteredSale;
import com.javap.fjla.dto.SaveSale;

import com.javap.fjla.persistance.entity.Product;
import com.javap.fjla.persistance.entity.Sale;
import com.javap.fjla.persistance.entity.User;
import com.javap.fjla.service.ProductService;
import com.javap.fjla.service.SaleService;
import com.javap.fjla.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private AuthenticationService authenticationService;

//    @GetMapping
//    public ResponseEntity<Page<Sale>> findAll(Pageable pageable){
//
//        Page<Sale> SalesPage = saleService.findAll(pageable);
//        if(SalesPage.hasContent()){
//            return ResponseEntity.ok(SalesPage);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{userName}")
//    public ResponseEntity<Page<Sale>> findAllByUserName(@PathVariable String userName,Pageable pageable){
//        Page<Sale> sales = saleService.findAllBycustomer(userName,pageable);
//
//        if(sales.hasContent()){
//            return ResponseEntity.ok(sales);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(Pageable pageable){

        Page<Sale> SalesPage = saleService.findAll(pageable);

        if(SalesPage.hasContent()){
            return ResponseEntity.ok(SalesPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{SaleId}")
    public ResponseEntity<Sale> findOneById(@PathVariable Long SaleId){

        Optional<Sale> sale = saleService.findOneById(SaleId);

        if(sale.isPresent()){
            return ResponseEntity.ok(sale.get());
        }
        return ResponseEntity.notFound().build();
    }


//    @GetMapping("/ByUsernameP/{username}")
//    public ResponseEntity<Page<Sale>> findallByUserName(@PathVariable String userName, Pageable pageable){
//
//        Page<Sale> sales = saleService.findAllBycustomer(userName, pageable);
//
//        if(sales.hasContent()){
//            return ResponseEntity.ok(sales);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/ByUsernameNP/{username}")
//    public ResponseEntity<List<Sale>> findallByUserNameNP(@PathVariable String userName){
//
//        List<Sale> sales = saleService.findAllSalesBycustomer(userName);
//
//        if(sales.size()>1){
//            return ResponseEntity.ok(sales);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping(value = "/TEST/usersByName/{userName}")
    public List<Sale> getUser(@PathVariable String userName, Pageable pageable){
        return saleService.findUserSales(userName, pageable);
    }





    @PostMapping
    public ResponseEntity<RegisteredSale> createOne(@RequestBody @Valid SaveSale saveSale){

        System.out.println("********  saveSale:"+saveSale.toString());

        User userVendedor = authenticationService.findLoggedInUser();
        System.out.println("********  userVendedor:"+userVendedor.toString());

        RegisteredSale sale = saleService.createOne(saveSale,userVendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }




    @PostMapping("/TEST")
    public ResponseEntity<String> createOne2(
            @RequestBody @Valid SaveSale saveSale){

        System.out.println("********  saveSale:"+saveSale.toString());
        return ResponseEntity.ok("TEST");

    }


}
