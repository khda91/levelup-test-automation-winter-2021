package ru.levelup.qa.at.selenuim.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SeleniumImplicitVsExplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://market.yandex.ru");
    }

    @Test
    public void implicitVsExplicitPositiveTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='2bd21f10 668cc030']")));

        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void implicitVsExplicitNegativeTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        WebElement catalogLayout = null;

        long start = System.currentTimeMillis();
        try {
            catalogLayout = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='2bd21f10 668cc0301']")));
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
        }
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void implicitMoreThanExplicitNegativeTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        WebElement catalogLayout = null;

        long start = System.currentTimeMillis();
        try {
            catalogLayout = new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='2bd21f10 668cc0301']")));
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
        }
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    // Правильный вариант использования явного и неявного ожидания
    public void implicitVsExplicitNegativeApplicableTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        WebElement catalogLayout = null;

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        long start = System.currentTimeMillis();
        try {
            catalogLayout = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='2bd21f10 668cc0301']")));
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        }
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void implicitVsExplicitNegativeBadSituationTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        SleepUtils.sleep(3000);

        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='2bd21f10 668cc030']"));

//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//        long start = System.currentTimeMillis();
//        try {
//            catalogLayout = new WebDriverWait(driver, 5)
//                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='2bd21f10 668cc030']")));
//        } finally {
//            long end = System.currentTimeMillis();
//            System.out.println(String.format("Timing: %s", (end - start)));
//            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//        }
        assertFalse(catalogLayout.isDisplayed());
    }

    @Test
    public void implicitVsExplicitNegativeBadSituation1Test() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-tid='42de86b 5a689c45']"));
        catalogButton.click();

        SleepUtils.sleep(3000);

        catalogButton.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        long start = System.currentTimeMillis();
        try {
            assertFalse(new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-tid='694dc470 506a0c10']"))));
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
