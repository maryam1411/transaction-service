package com.example.transaction.transactionservice;

import com.example.transaction.domain.Transaction;
import com.example.transaction.enums.TransactionType;
import com.example.transaction.exception.InvalidUserIdException;
import com.example.transaction.service.transaction.TransactionService;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TransactionServiceTest {

    private TransactionService transactionService;


    @BeforeEach
    public void setup() {
        this.transactionService = Mockito.mock(TransactionService.class);
    }

    @Test
    void saveTransactionInDatabase() throws InvalidUserIdException, ExecutionException, InterruptedException {
        Transaction transaction = Transaction
                .builder()
                .id(UUID.randomUUID())
                .amount(20000)
                .transactionType(TransactionType.CREDIT)
                .creditAccount("343434343435677777")
                .description("shopping")
                .purpose("Shopping purpose")
                .userName("d64e7886-c34f-4623-c016-5006230b1eb3")
                .transactionDate(DateTime.now())
                .build();
        transactionService.performTransaction(transaction);

    }


    @Test
    void getTransactionInDatabase() {
        // we can mock data and then compare don't hit the actual database
        transactionService.getTransaction("d64e7886-c34f-4623-c016-5006230b1eb3");

    }
}
