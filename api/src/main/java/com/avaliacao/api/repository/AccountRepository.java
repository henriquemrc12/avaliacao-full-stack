package com.avaliacao.api.repository;

import com.avaliacao.api.model.AccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long> {

    Optional<AccountModel> findByNumber(String number);
}
