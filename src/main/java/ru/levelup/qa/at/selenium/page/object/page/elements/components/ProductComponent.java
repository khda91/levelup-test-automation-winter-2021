package ru.levelup.qa.at.selenium.page.object.page.elements.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductComponent {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private WebElement rootElement;

    public ProductComponent(WebDriver driver, WebElement rootElement) {
        this.driver = driver;
        this.rootElement = rootElement;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }

    public ProductComponent clickAddToCompareButton() {
        WebElement addToCompare = wait.until(presenceOfNestedElementLocatedBy(rootElement,
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return this;
    }

    public String getTitle() {
        return wait.until(visibilityOf(rootElement
                .findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }
}
