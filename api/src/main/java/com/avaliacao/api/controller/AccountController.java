package com.avaliacao.api.controller;

import com.avaliacao.api.model.AccountModel;
import com.avaliacao.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {


    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccountModel> create() {
        return ResponseEntity.ok().body(service.create());
    }

    @GetMapping
    public ResponseEntity<List<AccountModel>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
