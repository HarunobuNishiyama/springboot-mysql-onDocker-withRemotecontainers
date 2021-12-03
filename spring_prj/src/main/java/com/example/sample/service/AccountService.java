package com.example.sample.service;

import com.example.sample.entity.AccountEntity;
import com.example.sample.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<AccountEntity> getAccount() {
        return accountRepository.findAll();
    }
}
