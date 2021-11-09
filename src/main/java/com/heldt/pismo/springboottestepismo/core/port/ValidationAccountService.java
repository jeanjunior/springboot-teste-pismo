package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomDocumentAlreadyExistsException;
import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Account;

public interface ValidationAccountService {

    void validate(Account account) throws CustomParameterConstraintException, CustomDocumentAlreadyExistsException;

}
