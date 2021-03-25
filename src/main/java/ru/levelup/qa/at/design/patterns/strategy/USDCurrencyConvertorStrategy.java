package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class USDCurrencyConvertorStrategy implements CurrencyConvertorStrategy {

    private static final BigDecimal EXCHANGE_RATE = BigDecimal.valueOf(72.50);

    @Override
    public BigDecimal covert(BigDecimal value) {
        return EXCHANGE_RATE.multiply(value);
    }
}
