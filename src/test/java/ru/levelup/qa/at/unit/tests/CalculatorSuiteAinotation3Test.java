package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSuiteAinotation3Test {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + "::beforeSuite");
    }

    @Test
    public void calculatorSumTest() {
        System.out.println(this.getClass().getName() + "::calculatorSumTest");
        Calculator calculator = new Calculator();
        double actualSum = calculator.sum(2, 2);
        assertEquals(actualSum, 4.0, 0.0001);
    }
}
