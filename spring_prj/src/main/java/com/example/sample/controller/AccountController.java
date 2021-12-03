package com.example.sample.controller;

import com.example.sample.entity.AccountEntity;
import com.example.sample.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("showaccount")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    List<AccountEntity> getTweet() {
        return accountService.getAccount();
    }
}
