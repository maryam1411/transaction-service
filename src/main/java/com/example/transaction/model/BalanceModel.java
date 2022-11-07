package com.example.transaction.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceModel {

    @NotEmpty
    private int balance;
}
