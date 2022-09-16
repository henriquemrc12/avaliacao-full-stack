package com.avaliacao.api.controller;

import com.avaliacao.api.dto.TransferCreateDto;
import com.avaliacao.api.dto.TransferFeeDto;
import com.avaliacao.api.model.TransferModel;
import com.avaliacao.api.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/transfer")
@CrossOrigin("*")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransferCreateDto dto) throws Exception {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransferModel>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/fee-amount")
    public ResponseEntity<TransferFeeDto> findFeeAmount(
            @RequestParam BigDecimal amount,
            @RequestParam("scheduleDate") String scheduleDateString) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate scheduleDate = LocalDate.parse(scheduleDateString, formatter);
        return ResponseEntity.ok().body(service.findTransferFees(amount, scheduleDate));
    }

}
