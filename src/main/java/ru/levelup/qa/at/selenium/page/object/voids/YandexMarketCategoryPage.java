package ru.levelup.qa.at.selenium.page.object.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketCategoryPage extends AbstractYandexMarketPage {

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void openSubCategory(String subCategory) {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.linkText(subCategory))).click();
    }
}
