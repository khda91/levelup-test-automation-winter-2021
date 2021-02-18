package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class CalculatorBaseTest {

    Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before method");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }
}
