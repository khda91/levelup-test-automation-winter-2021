package ru.levelup.qa.at.unit.tests.listener;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.tests.Calculator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

@Listeners({CalculatorListener.class})
public class CalculatorListenerTest {

    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] calculatorSumDataProvider() {
        return new Object[][]{
                {2, 2, 4.0},
                {3, 3, 6.0},
                {-5, -5, 10.0}
        };
    }

    @Test(dataProvider = "calculatorSumDataProvider")
    public void calculatorSumTest(int a, int b, double expected) {

        double actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expected, 0.0001);
    }

    @DataProvider(name = "Calculator Sum Negative Data Provider")
    public Object[][] calculatorSumNegativeDataProvider() {
        return new Object[][]{
                {2, 2, 3.1},
                {3, 3, 5.7},
                {-5, -5, -10.0}
        };
    }

    @Test(dataProvider = "Calculator Sum Negative Data Provider")
    public void calculatorSumNegativeTest(int a, int b, double expected) {
        double actualSum = calculator.sum(a, b);
        assertNotEquals(actualSum, expected, 0.0001);
    }

}
