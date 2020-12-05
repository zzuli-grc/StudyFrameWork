package com.study.service;

import com.study.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> findAll();
}
