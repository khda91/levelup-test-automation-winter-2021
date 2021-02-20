package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends CalculatorBaseTest {

    @Test
    public void calculatorDivideTest() {
        System.out.println("calculatorDivideTest -> started");
        double actualSum = calculator.divide(2, 2);
        assertEquals(actualSum, 1.0, 0.0001);
        System.out.println("calculatorDivideTest -> finished");
    }

    @Test
    void calculatorDivide2Test() {
        System.out.println("calculatorDivide2Test -> started");
        double actualSum = calculator.divide(4, 2);
        assertEquals(actualSum, 2.0, 0.0001);
        System.out.println("calculatorDivide2Test -> finished");
    }

    @Test
    protected void calculatorDivide() {
        System.out.println("calculatorDivide -> started");
        double actualSum = calculator.divide(3, 2);
        assertEquals(actualSum, 1.5, 0.0001);
        System.out.println("calculatorDivide -> finished");
    }

    @Test
    void calculator1Divide2Test() {
        System.out.println("calculator1Divide2Test -> started");
        double actualSum = calculator.divide(4, 2);
        assertEquals(actualSum, 2.0, 0.0001);
        System.out.println("calculator1Divide2Test -> finished");
    }

    @Test
    void calculator2Divide2Test() {
        System.out.println("calculator2Divide2Test -> started");
        double actualSum = calculator.divide(4, 2);
        assertEquals(actualSum, 2.0, 0.0001);
        System.out.println("calculator2Divide2Test -> finished");
    }

    @Test
    void calculator3Divide2Test() {
        System.out.println("calculator3Divide2Test -> started");
        double actualSum = calculator.divide(4, 2);
        assertEquals(actualSum, 2.0, 0.0001);
        System.out.println("calculator3Divide2Test -> finished");
    }

}
