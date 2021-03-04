package ru.levelup.qa.at.selenuim.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;


// Пример того как писать не надо ожидания
public class SeleniumWaitThreadSampleTest {

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
    public void threadSleepTest() {
        driver.findElement(id("header-search")).sendKeys("Холодильники");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(xpath("//*[text()='Найти']/..")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> productItems
                = driver.findElements(cssSelector("article[data-autotest-id='product-snippet'] h3[data-zone-name='title'] > a"));
        String expectedText = productItems.get(1).getText().trim();
        productItems.get(1).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualProductTitle = driver.findElement(cssSelector("div > h1")).getText().trim();

        assertEquals(actualProductTitle, expectedText, "Название товара не совпадает");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
