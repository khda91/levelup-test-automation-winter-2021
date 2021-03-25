package ru.levelup.qa.at.design.patterns.strategy;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CurrencyConvertorProviderImpl implements CurrencyConvertorProvider {

    private final CurrencyConvertorStrategy currencyConvertorStrategy;

    @Override
    public BigDecimal convert(BigDecimal value) {
        return currencyConvertorStrategy.covert(value);
    }
}
