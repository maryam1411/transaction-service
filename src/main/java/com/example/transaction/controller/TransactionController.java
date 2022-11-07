package com.example.transaction.controller;

import com.example.transaction.handler.TransactionHandler;
import com.example.transaction.model.TransactionModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
@Api(value = "Manage user transactions ")
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @Autowired
    public TransactionController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @PostMapping
    @ApiOperation(value = "Save user transaction information", response = Iterable.class)
    public HttpStatus performTransaction(@Valid @RequestBody TransactionModel transactionModel) {
        try {
            transactionHandler.performTransaction(transactionModel);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping({"/userId"})
    @ApiOperation(value = "Get user transaction information", response = Iterable.class)
    public TransactionModel getTransaction(@PathVariable String userId) {
        return transactionHandler.getTransaction(userId);

    }
}
