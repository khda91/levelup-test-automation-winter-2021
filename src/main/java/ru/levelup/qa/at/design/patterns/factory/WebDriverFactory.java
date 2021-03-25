package ru.levelup.qa.at.design.patterns.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class WebDriverFactory {

    private WebDriverFactory() {

    }

    public static WebDriver createWebDriver(final String browserName) {
        if (BrowserType.CHROME.equalsIgnoreCase(browserName)) {
            return createdChromeDriver();
        } else if (BrowserType.FIREFOX.equalsIgnoreCase(browserName)) {
            return createFirefoxDriver();
        } else if (BrowserType.EDGE.equals(browserName)) {
          return createdEdgeDriver();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser '%s'", browserName));
        }
    }

    private static WebDriver createdChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createdEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private WebDriver createRemoteWebDriver() {
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:5432/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
