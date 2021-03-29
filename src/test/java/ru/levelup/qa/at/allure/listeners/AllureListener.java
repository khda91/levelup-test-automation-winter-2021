package ru.levelup.qa.at.allure.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AllureListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        Optional<String> currentTestCaseOrStep = Allure.getLifecycle().getCurrentTestCaseOrStep();
        if (currentTestCaseOrStep.isPresent()) {
            Allure.getLifecycle().updateTestCase(testResult ->  {
                List<io.qameta.allure.model.Attachment> attachments = testResult.getAttachments();
                List<io.qameta.allure.model.Attachment> newAttachments = attachments.stream()
                        .filter(attachment -> "image/png".equals(attachment.getType()))
                        .collect(Collectors.toList());
                testResult.setAttachments(newAttachments);
            });
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long start = System.currentTimeMillis();
        try {
//            screenshot(AbstractSeleniumBaseTest.sharedWebDriver);
            WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
            screenshot(driver);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Screenshot execution time: %d", (end - start)));
        }

    }

    @Attachment(type = "image/png")
    private byte[] screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
