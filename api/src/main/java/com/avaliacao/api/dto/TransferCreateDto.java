package com.avaliacao.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferCreateDto {

    private String origin;

    private String destination;

    private String scheduleDate;

    private BigDecimal amount;

}
