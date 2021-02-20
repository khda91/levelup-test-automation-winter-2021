package ru.levelup.qa.at.unit.tests.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CalculatorListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " -> started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " -> finished with success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " -> finished with fail");
    }
}
