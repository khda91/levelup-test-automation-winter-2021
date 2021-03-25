package ru.levelup.qa.at.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketCategoryPage extends AbstractYandexMarketPage {

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketProductsPage openSubCategory(String subCategory) {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.linkText(subCategory))).click();
        return new YandexMarketProductsPage(driver);
    }
}
