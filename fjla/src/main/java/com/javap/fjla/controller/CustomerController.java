package com.javap.fjla.controller;

import com.javap.fjla.dto.RegisteredUser;
import com.javap.fjla.dto.SaveUser;
import com.javap.fjla.persistance.entity.User;
import com.javap.fjla.service.auth.AuthenticationService;
import io.jsonwebtoken.lang.Arrays;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll")
    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser){
        System.out.println(newUser);
        RegisteredUser registeredUser = authenticationService.registerOneCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);

    }


    @PreAuthorize("denyAll")
    @GetMapping
    public ResponseEntity<List<User>> findALL(){
        return ResponseEntity.ok(Arrays.asList(null));

    }
}
