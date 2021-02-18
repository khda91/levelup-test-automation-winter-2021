package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// surefire не запустит данный класс
public class CalculatorTestCalculator {

    @Test
    public void calculatorSumTest() {
        Calculator calculator = new Calculator();
        double actualSum = calculator.sum(2, 2);
        assertEquals(actualSum, 4.0, 0.0001);
    }

}
