package com.basri.SpringDataJPA.exception;

public class HomeNotFoundException extends RuntimeException {
    public HomeNotFoundException(String message) {
        super(message);
    }
}
