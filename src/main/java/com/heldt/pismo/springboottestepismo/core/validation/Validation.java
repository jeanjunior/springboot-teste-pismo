package com.heldt.pismo.springboottestepismo.core.validation;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;

public interface Validation<T> {

    void validate(T t) throws CustomParameterConstraintException;

}
