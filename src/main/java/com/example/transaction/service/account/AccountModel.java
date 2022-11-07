package com.example.transaction.service.account;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountModel {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
}
