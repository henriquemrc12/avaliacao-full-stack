package com.avaliacao.api.util;

public class AccountNumberGenerator {

    public static String generate() {
        Double accountNumber = Math.floor(Math.random()*(999999-100000+1)+100000);
        return accountNumber.toString().replace(".0", "");
    }
}
