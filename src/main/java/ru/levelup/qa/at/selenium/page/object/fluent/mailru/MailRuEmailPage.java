package ru.levelup.qa.at.selenium.page.object.fluent.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MailRuEmailPage {

    private WebDriver driver;

    public MailRuEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWriteEmailButtonVisible() {
        return new WebDriverWait(driver, 10)
                .until(visibilityOfElementLocated(xpath("//a[@title='Написать письмо']")))
                .isDisplayed();
    }
}
