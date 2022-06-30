package com.genuinecoder.springserver.controller;

public class BadRequestAlertException extends Exception {
    public BadRequestAlertException(String message) {
        super(message);
    }
}
