package com.heldt.pismo.springboottestepismo.core.service.impl;

import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountService;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import com.heldt.pismo.springboottestepismo.core.port.ValidationAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountServiceRepository repository;
    private ValidationAccountService validationAccountService;

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Account> findByDocumentNumber(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber);
    }

    @Override
    public Account save(Account account) {
        log.info("Inicio do save da account");
        validationAccountService.validate(account);

        log.info("Fez as validações, vai chamar o repositório para salvar");
        return repository.save(account);
    }

}
