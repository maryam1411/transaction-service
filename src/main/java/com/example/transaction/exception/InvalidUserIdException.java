package com.example.transaction.exception;

public class InvalidUserIdException extends Exception {

    private final static String MESSAGE = "invalid user id";

    public InvalidUserIdException() {
        super(MESSAGE);
    }
}
