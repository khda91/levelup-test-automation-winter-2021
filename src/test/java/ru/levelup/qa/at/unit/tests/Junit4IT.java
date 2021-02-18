package ru.levelup.qa.at.unit.tests;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Junit4IT {

    @Test
    public void calculatorSumTest() {
        Calculator calculator = new Calculator();
        double actualSum = calculator.sum(2, 4);
        assertEquals(actualSum, 4.0, 0.0001);
    }

//    @Test
//    void calculatorMultiplyTest() {
//        Calculator calculator = new Calculator();
//        double actualSum = calculator.multiply(2, 5);
//        assertEquals(actualSum, 4.0, 0.0001);
//    }

//    @Test
//    protected void calculatorMultiply() {
//        Calculator calculator = new Calculator();
//        double actualSum = calculator.multiply(3, 6);
//        assertEquals(actualSum, 4.0, 0.0001);
//    }

//     А он не будет работать так как private
//    @Test
//    private void privateCalculatorMultiplyTest() {
//        Calculator calculator = new Calculator();
//        double actualSum = calculator.multiply(1, 3);
//        assertEquals(actualSum, 4.0, 0.0001);
//    }
}
