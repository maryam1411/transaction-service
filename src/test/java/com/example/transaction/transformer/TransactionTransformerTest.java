package com.example.transaction.transformer;

import com.example.transaction.domain.Transaction;
import com.example.transaction.enums.TransactionType;
import com.example.transaction.model.TransactionModel;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class TransactionTransformerTest {

    private TransactionTransformer transactionTransformer;

    @BeforeEach
    public void setup() {
        this.transactionTransformer = new TransactionTransformer();
    }

    @Test
    public void whenNullModelGivenShouldReturnNullEntity() {
        TransactionModel transactionModel = null;
        Transaction entity = transactionTransformer.toEntity(transactionModel);
        Assertions.assertNull(entity);
    }

    @Test
    public void whenModelGivenShouldReturnEntity() {
        TransactionModel transactionModel = TransactionModel.builder()
                .amount(200)
                .description("added for test")
                .purpose("testing")
                .creditAccount("1234")
                .transactionType(TransactionType.DEBIT)
                .build();
        Transaction entity = transactionTransformer.toEntity(transactionModel);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("added for test", entity.getDescription());
        Assertions.assertEquals("testing", entity.getPurpose());
        Assertions.assertEquals("1234", entity.getCreditAccount());
        Assertions.assertEquals(TransactionType.DEBIT, entity.getTransactionType());
        Assertions.assertNotNull(entity.getTransactionDate());
    }

    @Test
    public void whenNullEntityGivenShouldReturnNull() {
        Transaction entity = null;
        TransactionModel model = transactionTransformer.toModel(entity);
        Assertions.assertNull(model);
    }

    @Test
    public void whenEntityGivenShouldReturnModel() {
        Transaction entity = Transaction.builder()
                .amount(200)
                .description("added for test")
                .purpose("bought a new phone")
                .creditAccount("1234")
                .transactionType(TransactionType.DEBIT)
                .transactionDate(DateTime.now())
                .id(UUID.fromString("d64e7886-c34f-4623-c016-5006230b1eb3"))
                .build();
        TransactionModel model = transactionTransformer.toModel(entity);
        Assertions.assertNotNull(model);
        Assertions.assertEquals("added for test", model.getDescription());
        Assertions.assertEquals("bought a new phone", model.getPurpose());
        Assertions.assertEquals("1234", model.getCreditAccount());
        Assertions.assertEquals(TransactionType.DEBIT, model.getTransactionType());
    }

}