package com.rakbank.exception;

public class DuplicateStudentException extends Exception {

    private String msg;

    public DuplicateStudentException(String msg) {
        super(msg);
    }

}
