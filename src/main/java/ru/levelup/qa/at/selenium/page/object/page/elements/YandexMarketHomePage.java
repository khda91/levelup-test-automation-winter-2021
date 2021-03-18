package ru.levelup.qa.at.selenium.page.object.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexMarketHomePage extends AbstractYandexMarketPage {

    private static final String URL = "https://market.yandex.ru/";

    @FindBy(xpath = "//*[@data-zone-name='category-link']//a")
    private List<WebElement> categoryLinks;                         // driver.findElements(By.xpath("//*[data-zone-name='category-link']//a"))

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketHomePage open() {
        driver.navigate().to(URL);
        return this;
    }

    public YandexMarketCategoryPage openCategory(String category) {
        for (WebElement categoryLink : categoryLinks) {
            if (categoryLink.getText().contains(category)) {
                categoryLink.click();
                break;
            }
        }
        return new YandexMarketCategoryPage(driver);
    }
}
