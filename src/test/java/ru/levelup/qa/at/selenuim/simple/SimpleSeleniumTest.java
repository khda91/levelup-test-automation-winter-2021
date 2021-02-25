package ru.levelup.qa.at.selenuim.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static ru.levelup.qa.at.utils.SleepUtils.sleep;

public class SimpleSeleniumTest {

    @Test
    public void simpleOpenYandexMarketPageChromeDriverTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/driver/chromedriver");
        var expectedTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
//        String expectedTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");

//        expectedTitle = 5; - не работает. В java нет динамической типизации

        sleep(4000);
        assertEquals(driver.getTitle(), expectedTitle);
        driver.quit();
    }

    @Test
    public void simpleOpenYandexMarketPageFirefoxDriverTest() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/selenium/driver/geckodriver");
        var expectedTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";

        WebDriver driver = new FirefoxDriver(new FirefoxOptions());
        driver.navigate().to("https://market.yandex.ru");

        sleep(4000);
        assertEquals(driver.getTitle(), expectedTitle);
        driver.quit();
    }

    @Test
    public void simpleOpenYandexMarketPageChromeDriverWithWebDriverManagerTest() {
        WebDriverManager.chromedriver().setup();
        var expectedTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");

        sleep(4000);
        assertEquals(driver.getTitle(), expectedTitle);
        driver.quit();
    }

}
