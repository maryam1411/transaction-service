package com.example.transaction.controller;

import com.example.transaction.handler.LoginHandler;
import com.example.transaction.model.LoginModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
@Api(value = "Login User")
public class LoginController {

    private final LoginHandler loginHandler;

    @Autowired
    public LoginController(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @PostMapping
    @ApiOperation(value = "Login user with valid credentials", response = Iterable.class)
    public ResponseEntity login(@Valid @RequestBody LoginModel loginModel) {
        try {
            return loginHandler.login(loginModel);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }
}
