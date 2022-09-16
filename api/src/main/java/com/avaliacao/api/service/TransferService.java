package com.avaliacao.api.service;

import com.avaliacao.api.dto.TransferCreateDto;
import com.avaliacao.api.dto.TransferFeeDto;
import com.avaliacao.api.model.TransferModel;
import com.avaliacao.api.model.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransferService {

    void create(TransferCreateDto dto) throws Exception;

    TransferFeeDto findTransferFees(BigDecimal amount, LocalDate scheduleDate) throws Exception;

    List<TransferModel> findAll();

    void changeTransferStatus(Long id, TransferStatus status) throws Exception;

    List<TransferModel> findTransferByScheduleDate(LocalDate date);

    TransferModel findById(Long id) throws Exception;
}
