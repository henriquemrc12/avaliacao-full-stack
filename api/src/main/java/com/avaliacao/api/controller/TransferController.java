package com.avaliacao.api.controller;

import com.avaliacao.api.model.AccountModel;
import com.avaliacao.api.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class TransferController {


    private final AccountService service;

    public TransferController(AccountService service) {
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
