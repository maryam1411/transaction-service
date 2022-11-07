package com.example.transaction.transformer;

import com.example.transaction.domain.Transaction;
import com.example.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransactionTransformer implements Transformer<TransactionModel, Transaction> {

    @Override
    public Transaction toEntity(TransactionModel model) {
        if (model == null)
            return null;
        else
            return Transaction.builder()
                    .id(UUID.randomUUID())
                    .userName(model.getUserName())
                    .transactionDate(DateTime.now())
                    .amount(model.getAmount())
                    .purpose(model.getPurpose())
                    .description(model.getDescription())
                    .creditAccount(model.getCreditAccount())
                    .transactionType(model.getTransactionType())
                    .build();
    }

    @Override
    public TransactionModel toModel(Transaction entity) {
        if (entity == null)
            return null;
        else
            return TransactionModel.builder()
                    .amount(entity.getAmount())
                    .purpose(entity.getPurpose())
                    .description(entity.getDescription())
                    .creditAccount(entity.getCreditAccount())
                    .transactionType(entity.getTransactionType())
                    .build();
    }

}
