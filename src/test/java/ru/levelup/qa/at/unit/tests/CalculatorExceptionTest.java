package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;

public class CalculatorExceptionTest {

    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest() {
        Calculator calculator = new Calculator();
        calculator.divideInt(10, 0);
    }

}
