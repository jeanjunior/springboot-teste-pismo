package com.heldt.pismo.springboottestepismo.core.calculate.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class CalculateNegativeTest {

    @InjectMocks
    private CalculateNegative calculate;

    @Test
    void calculate() {
        Assertions.assertEquals(calculate.calculate(new BigDecimal(10)), new BigDecimal(-10));
    }

    @Test
    void calculateNotEquals() {
        Assertions.assertNotEquals(calculate.calculate(new BigDecimal(10)), new BigDecimal(10));
    }

}