package com.example.transaction.service.account;

import com.example.transaction.exception.InvalidUserIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

@Service
public class AccountService {
    private final RestTemplate restTemplate;

    @Autowired
    public AccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public AccountModel getAccount(String userName) throws InvalidUserIdException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HashMap<String, String> params = new HashMap<>();
        params.put("userName", userName);

        try {
            return restTemplate.exchange("http://localhost:8080/api/accounts/{userName}", HttpMethod.GET,
                    entity, AccountModel.class, params).getBody();
        } catch (Exception ex) {
            throw new InvalidUserIdException();
        }

    }
}
