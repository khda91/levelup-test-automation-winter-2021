package ru.levelup.qa.at.selenuim.page.object.fluent;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.page.object.fluent.mailru.MailRuMainPage;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MailRuFluentPageObjectTest extends AbstractSeleniumBaseTest {

    @Test
    public void positiveTest() {
        boolean writeEmailButtonVisible = new MailRuMainPage(driver)
                .open()
                .enterEmail("khda91-test")
                .clickToEnterPassword()
                .enterPassword("vD!p[GpnxK52~Q/")
                .clickToLogin()
                .isWriteEmailButtonVisible();

        assertTrue(writeEmailButtonVisible);
    }

    @Test
    public void positiveTest1() {
        boolean writeEmailButtonVisible = new MailRuMainPage(driver)
                .open()
                .enterEmail("khda91-test")
                .clickToEnterPassword()
                .enterPassword("vD!p[GpnxK52~Q/")
                .clickToLoginSuccess()
                .isWriteEmailButtonVisible();

        assertTrue(writeEmailButtonVisible);
    }

    @Test
    public void negativeTest() {
        String actualErrorMessage = new MailRuMainPage(driver)
                .open()
                .enterEmail("khda91-test")
                .clickToEnterPassword()
                .enterPassword("vD!p[GpnxK51212~Q/")
                .clickToLogin(MailRuMainPage.class)
                .getErrorMessageText();

        assertEquals(actualErrorMessage, "Неверное имя или пароль");
    }

    @Test
    public void negativeTest1() {
        String actualErrorMessage = new MailRuMainPage(driver)
                .open()
                .enterEmail("khda91-test")
                .clickToEnterPassword()
                .enterPassword("vD!p[GpnxK51212~Q/")
                .clickToLoginError()
                .getErrorMessageText();

        assertEquals(actualErrorMessage, "Неверное имя или пароль");
    }

    @Test
    public void negativeTest2() {
        MailRuMainPage mainPage = new MailRuMainPage(driver)
                .open()
                .enterEmail("khda91-test")
                .clickToEnterPassword()
                .enterPassword("vD!p[GpnxK51212~Q/");

        mainPage.clickToLoginError();
        String actualErrorMessage = mainPage.getErrorMessageText();

        assertEquals(actualErrorMessage, "Неверное имя или пароль");
    }
}
