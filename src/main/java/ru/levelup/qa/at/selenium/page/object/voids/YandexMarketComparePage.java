package ru.levelup.qa.at.selenium.page.object.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketComparePage extends AbstractYandexMarketPage {

    @FindBy(css = "[data-tid='412661c'] a.cia-cs")
    private List<WebElement> productTitles;

    public YandexMarketComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        return productTitles
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
