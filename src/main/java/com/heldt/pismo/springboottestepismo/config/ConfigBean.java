package com.heldt.pismo.springboottestepismo.config;


import com.heldt.pismo.springboottestepismo.core.calculate.Calculate;
import com.heldt.pismo.springboottestepismo.core.calculate.impl.CalculateNegative;
import com.heldt.pismo.springboottestepismo.core.calculate.impl.CalculatePositive;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.model.OperationType;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import com.heldt.pismo.springboottestepismo.core.validation.impl.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Configuration
public class ConfigBean {

    @Bean
    public List<Validation<Transaction>> validationTransaction(
            ValidationOperation operation, ValidationAmount amount, ValidationAccount account, ValidationCreditAccount creditAccount
    ) {
        return List.of(operation, amount, account, creditAccount);
    }

    @Bean
    public List<Validation<Account>> validationAccountService(ValidationDocumentNumber documentNumber) {
        return List.of(documentNumber);
    }

    @Bean
    public Map<OperationType, Calculate<BigDecimal>> calculateAmountTransaction() {
        Calculate<BigDecimal> positive = new CalculatePositive();
        Calculate<BigDecimal> negative = new CalculateNegative();
        return Map.of(
                OperationType.COMPRA_A_VISTA, positive,
                OperationType.COMPRA_PARCELADA, positive,
                OperationType.SAQUE, positive,
                OperationType.PAGAMENTO, negative
        );
    }

}
