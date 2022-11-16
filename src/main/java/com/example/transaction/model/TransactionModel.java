package com.example.transaction.model;

import com.example.transaction.enums.TransactionType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionModel {
    @NotEmpty
    private String userName;
    @NotNull
    private int amount;
    @NotEmpty
    private String purpose;
    @NotEmpty
    private String description;
    @NotEmpty
    @NotBlank(message = "Credit account field is mandatory")
    private String creditAccount;
    @NotNull
    private TransactionType transactionType;
}
