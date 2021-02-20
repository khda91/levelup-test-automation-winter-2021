package ru.levelup.qa.at.unit.tests.dataproviders;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.tests.Calculator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CalculatorExternalDataProviderTest {

    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("=========================");
        calculator = new Calculator();
        System.out.println("Hellooooooooooooo");
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "calculatorSumDataProvider")
    public void calculatorSumTest(int a, int b, double expected) {
        System.out.println("calculatorSumTest -> started");
        double actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expected, 0.0001);
        System.out.println("calculatorSumTest -> finished");
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Calculator Sum Negative Data Provider")
    public void calculatorSumNegativeTest(int a, int b, double expected) {
        System.out.println("calculatorSumNegativeTest -> started");
        double actualSum = calculator.sum(a, b);
        assertNotEquals(actualSum, expected, 0.0001);
        System.out.println("calculatorSumNegativeTest -> finished");
    }

}
