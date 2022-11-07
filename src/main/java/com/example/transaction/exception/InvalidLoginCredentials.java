package com.example.transaction.exception;

public class InvalidLoginCredentials extends Exception {

    private final static String MESSAGE = "invalid credentials";

    public InvalidLoginCredentials() {
        super(MESSAGE);
    }
}
