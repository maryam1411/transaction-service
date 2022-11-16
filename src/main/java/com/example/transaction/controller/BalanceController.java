package com.example.transaction.controller;

import com.example.transaction.handler.TransactionHandler;
import com.example.transaction.model.BalanceModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/balances")
@Api(value = "Get balance of the user")
public class BalanceController {

    private final TransactionHandler transactionHandler;

    @Autowired
    public BalanceController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }


    @GetMapping("/{userName}")
    @ApiOperation(value = "Get user balance", response = Iterable.class)
    public BalanceModel getBalance(@PathVariable String userName) {
        return transactionHandler.getBalance(userName);
    }

}
