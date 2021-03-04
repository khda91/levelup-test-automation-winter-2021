package ru.levelup.qa.at.selenuim.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;


public class SeleniumExplicitWaitSampleTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");
    }

    @Test
    public void explicitWaitSampleTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(id("header-search"))).sendKeys("Холодильники");
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//*[text()='Найти']/.."))).click();

        String currentWindowHandle = driver.getWindowHandle();
        List<WebElement> productItems
                = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(cssSelector("article[data-autotest-id='product-snippet'] h3[data-zone-name='title'] > a"), 5));
        String expectedText = productItems.get(1).getText().trim();
        productItems.get(1).click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        String actualProductTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("div > h1"))).getText().trim();

        assertEquals(actualProductTitle, expectedText, "Название товара не совпадает");
    }

    @Test
    public void explicitWaitSampleFailTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10, 1853);

        wait.until(ExpectedConditions.visibilityOfElementLocated(id("header-search"))).sendKeys("Холодильники");
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(xpath("//*[text()='Найти']/.."))).click();

        String currentWindowHandle = driver.getWindowHandle();
        List<WebElement> productItems
                = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(cssSelector("article[data-autotest-id='product-snippet'] h3[data-zone-name='title'] > a"), 5));
        String expectedText = productItems.get(1).getText().trim();
        productItems.get(1).click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        String actualProductTitle = "";

        long start = System.currentTimeMillis();
        try {
            actualProductTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("div > h11"))).getText().trim();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Unable located element during time %d ms", (end - start)));
        }

        assertEquals(actualProductTitle, expectedText, "Название товара не совпадает");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
