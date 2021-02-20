package ru.levelup.qa.at.unit.tests.dataproviders;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.tests.Calculator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CalculatorDataProviderTest {

    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("=========================");
        calculator = new Calculator();
        System.out.println("Hellooooooooooooo");
    }

    @DataProvider
    public Object[][] calculatorSumDataProvider() {
        return new Object[][]{
                {2, 2, 4.0},
                {3, 3, 6.0},
                {-5, -5, -10.0}
        };
    }

    @Test(dataProvider = "calculatorSumDataProvider")
    public void calculatorSumTest(int a, int b, double expected) {
        System.out.println("calculatorSumTest -> started");
        double actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expected, 0.0001);
        System.out.println("calculatorSumTest -> finished");
    }

    @DataProvider(name = "Calculator Sum Negative Data Provider")
    public Object[][] calculatorSumNegativeDataProvider() {
        return new Object[][]{
                {2, 2, 3.1},
                {3, 3, 5.7},
                {-5, -5, 10.0}
        };
    }

    @Test(dataProvider = "Calculator Sum Negative Data Provider")
    public void calculatorSumNegativeTest(int a, int b, double expected) {
        System.out.println("calculatorSumNegativeTest -> started");
        double actualSum = calculator.sum(a, b);
        assertNotEquals(actualSum, expected, 0.0001);
        System.out.println("calculatorSumNegativeTest -> finished");
    }

}
