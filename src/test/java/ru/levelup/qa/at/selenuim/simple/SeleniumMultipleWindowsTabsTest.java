package ru.levelup.qa.at.selenuim.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.SleepUtils;

import java.util.ArrayList;
import java.util.List;

public class SeleniumMultipleWindowsTabsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void multipleWindowsTest() {
        Keys ctrlCmd = System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.LEFT_CONTROL;

        driver.navigate().to("https://market.yandex.ru");

        SleepUtils.sleep(3000);

        var currentWindowHandle = driver.getWindowHandle(); // id - текущего окна/вкладки в которых мы работаем на данный момент
        System.out.println("Yandex Market Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();

        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Электроника']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        SleepUtils.sleep(3000);
        System.out.println("Yandex Market Электроника Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();
    }

    @Test
    public void multipleWindowsSwitchTest() {
        Keys ctrlCmd = System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.LEFT_CONTROL;

        driver.navigate().to("https://market.yandex.ru");

        SleepUtils.sleep(3000);

        var currentWindowHandle = driver.getWindowHandle(); // id - текущего окна/вкладки в которых мы работаем на данный момент
        System.out.println("Yandex Market Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();

        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Электроника']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        SleepUtils.sleep(3000);
        System.out.println("Yandex Market Электроника Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();


        element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Бытовая техника']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        SleepUtils.sleep(3000);
        System.out.println("Yandex Market Бытовая техника Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();

        element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Компьютеры']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        SleepUtils.sleep(3000);
        System.out.println("Yandex Market Компьютеры Opened -> " + driver.getWindowHandles()); // список всех открытых окон/вкладок
        System.out.println();



        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                SleepUtils.sleep(1500);
                if (driver.getTitle().contains("Компьютерная техника")) {
                    currentWindowHandle = windowHandle;
                    System.out.println("We are Here!!! " + driver.getTitle());
                    break;
                } else {
                    System.out.println("Opened tab -> " + driver.getTitle());
                }
            }
        }

        SleepUtils.sleep(4000);

        driver.close();

        SleepUtils.sleep(4000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
