package com.heldt.pismo.springboottestepismo.core.calculate.impl;

import com.heldt.pismo.springboottestepismo.core.calculate.Calculate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CalculatePositive implements Calculate<BigDecimal> {

    @Override
    public BigDecimal calculate(BigDecimal value) {
        return value;
    }

}
