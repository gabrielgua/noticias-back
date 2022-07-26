package com.gabriel.noticias.api.exception;

public class StandardError extends RuntimeException{

    public StandardError(String message) {
        super(message);
    }
}
