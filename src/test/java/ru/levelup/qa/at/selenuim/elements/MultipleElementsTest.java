package ru.levelup.qa.at.selenuim.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.SleepUtils;

import java.util.List;

public class MultipleElementsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void multipleElementsTest() {
        driver.navigate().to("https://market.yandex.ru");
        SleepUtils.sleep(1000);

        List<WebElement> elements = driver.findElements(By.cssSelector("[data-zone-name='category-link']"));
        System.out.println("Category Links Collection size: " + elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        System.out.println();

        WebElement element = driver.findElement(By.cssSelector("[data-zone-name='category-link']"));
        System.out.println("Category link web element: " + element.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
