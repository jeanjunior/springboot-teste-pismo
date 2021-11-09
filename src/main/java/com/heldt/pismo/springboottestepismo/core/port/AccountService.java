package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.core.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(Long id);

    Optional<Account> findByDocumentNumber(String documentNumber);

    Account save(Account account);

}
