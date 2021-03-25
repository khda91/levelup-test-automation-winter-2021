package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface CurrencyConvertorStrategy {

    BigDecimal covert(BigDecimal value);
}
