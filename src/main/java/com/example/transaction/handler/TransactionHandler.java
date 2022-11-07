package com.example.transaction.handler;

import com.example.transaction.domain.Transaction;
import com.example.transaction.exception.InvalidUserIdException;
import com.example.transaction.model.BalanceModel;
import com.example.transaction.model.TransactionModel;
import com.example.transaction.service.transaction.TransactionService;
import com.example.transaction.transformer.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class TransactionHandler {
    private final TransactionTransformer transactionTransformer;
    private final TransactionService transactionService;

    @Autowired
    public TransactionHandler(TransactionTransformer transactionTransformer, TransactionService transactionService) {
        this.transactionTransformer = transactionTransformer;
        this.transactionService = transactionService;
    }

    public void performTransaction(TransactionModel transactionModel) throws InvalidUserIdException, ExecutionException, InterruptedException {
        Transaction transaction = transactionTransformer.toEntity(transactionModel);
        transactionService.performTransaction(transaction);

    }

    public BalanceModel getBalance(String userId) {
        Transaction transaction = transactionService.calculateBalance(userId);
        return BalanceModel
                .builder()
                .balance(transaction.getAmount())
                .build();
    }

    public TransactionModel getTransaction(String userId) {
        Transaction transaction = transactionService.getTransaction(userId);
        return transactionTransformer.toModel(transaction);
    }
}
