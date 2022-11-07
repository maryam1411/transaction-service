package com.example.transaction.service.login;

import com.example.transaction.model.LoginModel;
import org.springframework.http.ResponseEntity;


public interface LoginService {
    ResponseEntity login(LoginModel loginModel) throws Exception;
}
