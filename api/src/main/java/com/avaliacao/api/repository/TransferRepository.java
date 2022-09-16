package com.avaliacao.api.repository;

import com.avaliacao.api.model.TransferModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransferRepository extends CrudRepository<TransferModel, Long> {

    List<TransferModel> findAllByTransferEffectiveDate(LocalDate date);
}
