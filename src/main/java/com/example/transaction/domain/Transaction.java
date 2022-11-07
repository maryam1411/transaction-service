package com.example.transaction.domain;

import com.example.transaction.enums.TransactionType;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("transaction")
public class Transaction {

    @Id
    private UUID id;
    private String userName;
    private int amount;
    private TransactionType transactionType;
    private String purpose;
    private String description;
    private DateTime transactionDate;
    private String creditAccount;
}
