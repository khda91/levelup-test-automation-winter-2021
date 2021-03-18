package ru.levelup.qa.at.selenium.page.object.fluent.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MailRuMainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@data-testid='login-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-testid='password-input']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@data-testid='enter-password']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@data-testid='login-to-mail']")
    private WebElement loginButton;

    @FindBy(className = "error")
    private WebElement errorMessage;

    public MailRuMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public MailRuMainPage open() {
        driver.navigate().to("https://mail.ru");
        return this;
    }

    public MailRuMainPage enterEmail(String email) {
        wait.until(visibilityOf(emailInput)).sendKeys(email);
        return this;
    }

    public MailRuMainPage enterPassword(String password) {
        wait.until(visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }

    public MailRuMainPage clickToEnterPassword() {
        wait.until(elementToBeClickable(nextButton)).click();
        return this;
    }

    public MailRuEmailPage clickToLogin() {
        wait.until(elementToBeClickable(loginButton)).click();
        return new MailRuEmailPage(driver);
    }

    public MailRuEmailPage clickToLoginSuccess() {
        wait.until(elementToBeClickable(loginButton)).click();
        return new MailRuEmailPage(driver);
    }

    public MailRuMainPage clickToLoginError() {
        wait.until(elementToBeClickable(loginButton)).click();
        return this;
    }

    public <T> T clickToLogin(Class<T> pageClass) {
        wait.until(elementToBeClickable(loginButton)).click();
        try {
            return (T) pageClass.getConstructors()[0].newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getErrorMessageText() {
        return wait.until(visibilityOf(errorMessage)).getText();
    }
}
