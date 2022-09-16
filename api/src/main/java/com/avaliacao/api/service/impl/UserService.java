package com.avaliacao.api.service.impl;

public interface TransferService {

    void create(TransferCreateDto dto);

    void findTransferFees(TransferCreateDto dto);

    void findAll();

    void findById(String id);

}
