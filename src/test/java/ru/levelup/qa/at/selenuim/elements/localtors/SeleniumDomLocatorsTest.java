package ru.levelup.qa.at.selenuim.elements.localtors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.SleepUtils;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SeleniumDomLocatorsTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://market.yandex.ru");
    }

    @Test
    public void idLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.id("header-search"));
        headerSearchTextBox.sendKeys("Холодильник");
        SleepUtils.sleep(2500);
    }

    @Test
    public void classNameLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.className("nQ8aBP7fBN"));
        headerSearchTextBox.sendKeys("Телевизор");
        SleepUtils.sleep(2500);
    }

    @Test
    public void nameLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.name("text"));
        headerSearchTextBox.sendKeys("Стиральная машина");
        SleepUtils.sleep(2500);
    }

    @Test
    public void tagLocatorTest() {
        List<WebElement> spans = driver.findElements(By.tagName("span"));
        System.out.println(String.format("Amount of spans: %d", spans.size()));
//        spans.get(173).click();
    }

    @Test
    public void linkTextLocatorTest() {
        WebElement link = driver.findElement(By.linkText("Все товары"));
        link.click();
        SleepUtils.sleep(2500);
        assertEquals(driver.getTitle(), "Подарки на 8 марта на Яндекс.Маркете!");
    }

    @Test
    public void linkTextIncorrectLocatorTest() {
        WebElement link = driver.findElement(By.linkText("Лучшее"));
        link.click();
        SleepUtils.sleep(2500);
    }

    @Test
    public void linkTextWithNestedLocatorTest() {
        WebElement link = driver.findElement(By.linkText("Электроника"));
        link.click();
        SleepUtils.sleep(2500);
        assertEquals(driver.getTitle(), "Электроника — купить на Яндекс.Маркете");
    }

    @Test
    public void partialLinkTextWithLocatorTest() {
        WebElement link = driver.findElement(By.partialLinkText("товары"));
        link.click();
        SleepUtils.sleep(2500);
        assertEquals(driver.getTitle(), "Подарки на 8 марта на Яндекс.Маркете!");
    }

    @Test
    public void multipleClassesLocatorTest() {
//        WebElement link = driver.findElement(By.className("_381y5orjSo _169PIVxNxt")); // вот так делать не нужно, достаточно одного значения из аттрибута класс
        WebElement link = driver.findElement(By.className("_381y5orjSo")); // правильный вариант
//        link.click();
        SleepUtils.sleep(2500);
        assertEquals(driver.getTitle(), "Подарки на 8 марта на Яндекс.Маркете!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
