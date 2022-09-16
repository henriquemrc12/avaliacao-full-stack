package com.avaliacao.api.repository;

import com.avaliacao.api.model.AccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends CrudRepository<AccountModel, UUID> {
}
