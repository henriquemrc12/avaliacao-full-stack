package com.avaliacao.api.service.impl;

import com.avaliacao.api.model.AccountModel;
import com.avaliacao.api.repository.AccountRepository;
import com.avaliacao.api.service.AccountService;
import com.avaliacao.api.util.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountModel create() {
        try {
            String accountNumber = AccountNumberGenerator.generate();

            AccountModel newAccount = new AccountModel();
            newAccount.setNumber(accountNumber);

            return repository.save(newAccount);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<AccountModel> findAll() {
        try {
            return (List<AccountModel>) repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AccountModel findByAccountNumber(String number) throws Exception {
        try {
            return repository.findByNumber(number).orElseThrow(()-> new Exception("Conta não encontrada com número: " + number));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
