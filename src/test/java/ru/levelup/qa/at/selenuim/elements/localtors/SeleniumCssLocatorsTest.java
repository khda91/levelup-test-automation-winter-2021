package ru.levelup.qa.at.selenuim.elements.localtors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class SeleniumCssLocatorsTest {

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
        WebElement headerSearchTextBox = driver.findElement(By.cssSelector("#header-search"));
        headerSearchTextBox.sendKeys("Холодильник");
        SleepUtils.sleep(2500);
    }

    @Test
    public void classNameLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.cssSelector(".nQ8aBP7fBN"));
        headerSearchTextBox.sendKeys("Телевизор");
        SleepUtils.sleep(2500);
    }

    @Test
    public void nameLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.cssSelector("[name='text']"));
        headerSearchTextBox.sendKeys("Стиральная машина");
        SleepUtils.sleep(2500);
    }

    @Test
    public void tagLocatorTest() {
        List<WebElement> spans = driver.findElements(By.cssSelector("span"));
        System.out.println(String.format("Amount of spans: %d", spans.size()));
//        spans.get(173).click();
    }

    @Test
    public void otherAttributesLocatorTest() {
        List<WebElement> divs = driver.findElements(By.cssSelector("div[data-zone-name='category-link']"));
        System.out.println(String.format("Amount of divs: %d", divs.size()));
        divs.forEach(div -> System.out.println(div.getText()));
    }

    @Test
    public void complexLocatorTest() {
        WebElement headerSearchTextBox = driver.findElement(By.cssSelector("#header-search"));
        headerSearchTextBox.sendKeys("Холодильник");
        driver.findElement(By.cssSelector("button._1XiEJDPVpk")).click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void multipleClassesLocatorTest() {
//        WebElement link = driver.findElement(By.className("_381y5orjSo _169PIVxNxt")); // вот так делать не нужно, достаточно одного значения из аттрибута класс
        WebElement link = driver.findElement(By.className("_381y5orjSo")); // правильный вариант
//        link.click();
        SleepUtils.sleep(2500);
        assertEquals(driver.getTitle(), "Подарки на 8 марта на Яндекс.Маркете!");
    }

    @Test
    public void cascadeSearchTest() {
        long start = System.currentTimeMillis();
        SleepUtils.sleep(3000);
        WebElement menu = driver.findElement(By.cssSelector("div._21NjfY1k45"));
        SleepUtils.sleep(1500);
        List<WebElement> menuItems = menu.findElements(By.cssSelector("[data-zone-name='category-link']"));

        SleepUtils.sleep(1500);
        for (WebElement menuItem : menuItems) {
            try {
                WebElement span = menuItem.findElement(By.cssSelector("span"));
                if ("Зоо".equals(span.getText())) {
                    span.click();
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("exception");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(String.format("Execution time: %d", ((end - start))));

        SleepUtils.sleep(2500);
    }

    @Test
    public void searchTest() {
        long start = System.currentTimeMillis();
        SleepUtils.sleep(3000);
        SleepUtils.sleep(1500);
        List<WebElement> menuItems = driver.findElements(By.cssSelector("[data-zone-name='category-link'] > span"));

        SleepUtils.sleep(1500);
        for (WebElement menuItem : menuItems) {
            try {
                if ("Зоо".equals(menuItem.getText())) {
                    menuItem.click();
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("exception");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(String.format("Execution time: %d", ((end - start))));

        SleepUtils.sleep(2500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
