package com.example.transaction.service.login;

import com.example.transaction.exception.InvalidLoginCredentials;
import com.example.transaction.service.account.AccountModel;
import com.example.transaction.model.LoginModel;
import com.example.transaction.responses.AuthenticationResponse;
import com.example.transaction.security.JwtTokenUtil;
import com.example.transaction.security.JwtUserDetailsService;
import com.example.transaction.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    private final JwtTokenUtil jwtTokenUtil;
    private final AccountService accountService;
    private final JwtUserDetailsService userDetailsService;

    @Autowired
    public LoginServiceImpl(JwtTokenUtil jwtTokenUtil, AccountService accountService, JwtUserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.accountService = accountService;
        this.userDetailsService = userDetailsService;
    }

    public ResponseEntity login(LoginModel loginModel) throws Exception {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        AccountModel registeredAccount = accountService.getAccount(loginModel.getUserName());
        if (loginModel.getUserName().equalsIgnoreCase(registeredAccount.getUserName()) && encoder.matches(loginModel.getPassword(),
                registeredAccount.getPassword())) {
            return ResponseEntity.ok(new AuthenticationResponse(loginModel.getUserName(), true, token));
        }
        throw new InvalidLoginCredentials();


    }
}

