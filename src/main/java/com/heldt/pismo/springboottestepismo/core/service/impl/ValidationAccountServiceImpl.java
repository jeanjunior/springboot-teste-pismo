package com.heldt.pismo.springboottestepismo.core.service.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomDocumentAlreadyExistsException;
import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.ValidationAccountService;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class ValidationAccountServiceImpl implements ValidationAccountService {

    private final List<Validation<Account>> validations;

    @Override
    public void validate(Account account) throws CustomParameterConstraintException, CustomDocumentAlreadyExistsException {
        log.info("Iniciando as validações da account");
        validations.forEach(v -> v.validate(account));
    }

}
