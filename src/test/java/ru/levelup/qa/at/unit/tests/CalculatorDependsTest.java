package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDependsTest {

    @Test
    public void testA() {
        Calculator calc = new Calculator();
        int res = calc.divideInt(10, 10);
        assertEquals(1, res);
    }

    @Test(dependsOnMethods = "testA")
    public void testB() {
        Calculator calc = new Calculator();
        int res = calc.divideInt(5, 10);
        assertEquals(1, res);
    }

    @Test(dependsOnMethods = "testB")
    public void testC() {
        Calculator calc = new Calculator();
        int res = calc.divideInt(25, 5);
        assertEquals(5, res);
    }
}
