package ru.levelup.qa.at.selenuim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractSeleniumBaseTest {

    protected WebDriver driver;

    public static WebDriver sharedWebDriver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//        sharedWebDriver = driver;
//    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        sharedWebDriver = driver;
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        sharedWebDriver = null;
    }

}
