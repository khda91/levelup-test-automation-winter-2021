package ru.levelup.qa.at.unit.tests.dataproviders;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public Object[][] calculatorSumDataProvider() {
        return new Object[][]{
                {2, 2, 4.0},
                {3, 3, 6.0},
                {-5, -5, -10.0}
        };
    }
    @DataProvider(name = "Calculator Sum Negative Data Provider")
    public Object[][] calculatorSumNegativeDataProvider() {
        return new Object[][]{
                {2, 2, 3.1},
                {3, 3, 5.7},
                {-5, -5, 10.0}
        };
    }

}
