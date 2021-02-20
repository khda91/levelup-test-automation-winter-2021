package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class CalculatorBaseTest {

    Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

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

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }
}
