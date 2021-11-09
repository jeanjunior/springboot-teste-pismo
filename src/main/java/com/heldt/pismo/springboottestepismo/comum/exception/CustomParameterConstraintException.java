package com.heldt.pismo.springboottestepismo.comum.exception;

import java.io.Serializable;

public class CustomParameterConstraintException extends RuntimeException implements Serializable {

    public CustomParameterConstraintException() {
        super();
    }

    public CustomParameterConstraintException(String message) {
        super(message);
    }

}
