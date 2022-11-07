package com.example.transaction.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginModel {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
}

