package com.avaliacao.api.service;

import com.avaliacao.api.model.AccountModel;

import java.util.List;

public interface AccountService {

    AccountModel create();

    List<AccountModel> findAll();

    AccountModel findByAccountNumber(String number) throws Exception;
}
