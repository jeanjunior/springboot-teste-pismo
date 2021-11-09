package com.heldt.pismo.springboottestepismo.comum.exception;

public class CustomDocumentAlreadyExistsException extends RuntimeException {

    public CustomDocumentAlreadyExistsException() {
    }

    public CustomDocumentAlreadyExistsException(String message) {
        super(message);
    }

}
