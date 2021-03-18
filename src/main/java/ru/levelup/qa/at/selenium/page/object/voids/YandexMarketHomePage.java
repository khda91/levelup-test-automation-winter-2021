package ru.levelup.qa.at.selenium.page.object.voids;

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

    public void open() {
        driver.navigate().to(URL);
    }

    public void openCategory(String category) {
        for (WebElement categoryLink : categoryLinks) {
            if (categoryLink.getText().contains(category)) {
                categoryLink.click();
                break;
            }
        }
    }
}
