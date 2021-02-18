package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest extends CalculatorBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        System.out.println("=========================");
        calculator = new Calculator();
        System.out.println("Hellooooooooooooo");
    }

    @Test
    public void calculatorSumTest() {
        System.out.println("calculatorSumTest -> started");
        double actualSum = calculator.sum(2, 2);
        assertEquals(actualSum, 4.0, 0.0001);
        System.out.println("calculatorSumTest -> finished");
    }

    @Test
    void calculatorMultiplyTest() {
        System.out.println("calculatorMultiplyTest -> started");
        double actualSum = calculator.multiply(2, 2);
        assertEquals(actualSum, 4.0, 0.0001);
        System.out.println("calculatorMultiplyTest -> finished");
    }

    @Test
    protected void calculatorMultiply() {
        System.out.println("calculatorMultiply -> started");
        double actualSum = calculator.multiply(3, 2);
        assertEquals(actualSum, 6.0, 0.0001);
        System.out.println("calculatorMultiply -> finished");
    }

    // А он не будет работать так как private
    @Test
    private void privateCalculatorMultiplyTest() {
        System.out.println("privateCalculatorMultiplyTest -> started");
        double actualSum = calculator.multiply(1, 2);
        assertEquals(actualSum, 3.0, 0.0001);
        System.out.println("privateCalculatorMultiplyTest -> finished");
    }
}
