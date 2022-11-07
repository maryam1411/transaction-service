package com.example.transaction.security;

import com.example.transaction.service.account.AccountModel;
import com.example.transaction.service.account.AccountService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    @Autowired
    public JwtUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AccountModel accountModel = accountService.getAccount(userName);
        if (accountModel == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(accountModel.getUserName(), accountModel.getPassword(),
                new ArrayList<>());
    }


}
