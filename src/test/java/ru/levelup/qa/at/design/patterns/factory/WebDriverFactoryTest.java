package ru.levelup.qa.at.design.patterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.SleepUtils;

public class WebDriverFactoryTest {

    @Test
    public void openChromeDriverTest() {
        WebDriver chrome = WebDriverFactory.createWebDriver("Chrome");
        chrome.navigate().to("https://ya.ru");
        SleepUtils.sleep(3000);

        String browserName = ((RemoteWebDriver) chrome).getCapabilities().getBrowserName();

        Assert.assertTrue("chrome".equalsIgnoreCase(browserName), "Opened browser not Chrome");

        chrome.quit();
    }

    @Test
    public void openFirefoxDriverTest() {
        WebDriver firefox = WebDriverFactory.createWebDriver("FiREfoX");
        firefox.navigate().to("https://ya.ru");
        SleepUtils.sleep(3000);

        String browserName = ((RemoteWebDriver) firefox).getCapabilities().getBrowserName();

        Assert.assertTrue("FiREfoX".equalsIgnoreCase(browserName), "Opened browser not FiREfoX");

        firefox.quit();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void openUnsupportedDriverTest() {
        WebDriverFactory.createWebDriver("Opera");
    }

}
