package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class EURCurrencyConvertorStrategy implements CurrencyConvertorStrategy {

    private static final BigDecimal EXCHANGE_RATE = BigDecimal.valueOf(90.5);

    @Override
    public BigDecimal covert(BigDecimal value) {
        return EXCHANGE_RATE.multiply(value);
    }
}
