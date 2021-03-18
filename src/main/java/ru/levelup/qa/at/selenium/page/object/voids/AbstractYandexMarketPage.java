package ru.levelup.qa.at.selenium.page.object.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractYandexMarketPage {

    protected WebDriver driver;

    protected AbstractYandexMarketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
