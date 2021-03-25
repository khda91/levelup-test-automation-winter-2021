package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface CurrencyConvertorProvider {

    BigDecimal convert(BigDecimal value);
}
