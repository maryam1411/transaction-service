package com.example.transaction.service.transaction;

import com.example.transaction.domain.Transaction;
import com.example.transaction.exception.InvalidUserIdException;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface TransactionService {

    void performTransaction(Transaction transaction) throws InvalidUserIdException, ExecutionException, InterruptedException;

    Transaction calculateBalance(String userName);

    Optional<Transaction> getTransaction(UUID transactionId);

}
