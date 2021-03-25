package ru.levelup.qa.at.design.patterns.strategy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CurrencyConvertorProviderTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {new USDCurrencyConvertorStrategy(), BigDecimal.valueOf(2), BigDecimal.valueOf(145.0)},
                {new EURCurrencyConvertorStrategy(), BigDecimal.valueOf(2), BigDecimal.valueOf(181.0)}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void currencyConverterTest(CurrencyConvertorStrategy strategy, BigDecimal value, BigDecimal expected) {
        CurrencyConvertorProvider currencyConvertorProvider = new CurrencyConvertorProviderImpl(strategy);
        BigDecimal actual = currencyConvertorProvider.convert(value);
        assertEquals(actual, expected);
    }

}
