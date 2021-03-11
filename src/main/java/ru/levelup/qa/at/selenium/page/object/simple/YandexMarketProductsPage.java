package ru.levelup.qa.at.selenium.page.object.simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YandexMarketProductsPage extends AbstractYandexMarketPage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> productList;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketProductsPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompare(int productNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement addToCompare = wait.until(presenceOfNestedElementLocatedBy(productList.get(productNumber),
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return wait.until(visibilityOf(productList.get(productNumber)
                .findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }

    public YandexMarketComparePage clickCompareButton() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(compareButton)).click();
        return new YandexMarketComparePage(driver);
    }
}
