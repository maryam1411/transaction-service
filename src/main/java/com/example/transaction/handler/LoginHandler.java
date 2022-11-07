package com.example.transaction.handler;

import com.example.transaction.model.LoginModel;
import com.example.transaction.service.login.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginHandler {

    LoginServiceImpl loginService;

    @Autowired

    public LoginHandler(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    public ResponseEntity login(LoginModel loginModel) throws Exception {
        return loginService.login(loginModel);
    }
}
