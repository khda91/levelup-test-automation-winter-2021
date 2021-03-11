package ru.levelup.qa.at.selenuim.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ScriptingScenarioSampleTest extends AbstractSeleniumBaseTest {

    WebDriverWait wait;
    Actions actions;

    @Test
    public void scriptingTest() {
        System.out.println("Browser Name property -> " + System.getProperty("browser.name"));
        System.out.println("Site Url property -> " + System.getProperty("site.url"));
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);

        // 1. Открыть Яндекс маркет
        driver.navigate().to("https://market.yandex.ru/");

        // 2. Выбрать категорию "Компьютеры"
        wait.until(elementToBeClickable(xpath("//span[contains(text(),'Компьютеры')]"))).click();

        // 3. Выбрать подкатегорию "Ноутбуки"
        wait.until(elementToBeClickable(linkText("Ноутбуки"))).click();

        List<String> selectedProductNames = new ArrayList<>();
        List<WebElement> products = wait.until(numberOfElementsToBeMoreThan(cssSelector("[data-autotest-id='product-snippet']"), 3));
        // 4. Добавить первый товар к сравнению
        selectedProductNames.add(addProductToCompare(products, 0));

        // 5. добавить второй товар к сравнению
        selectedProductNames.add(addProductToCompare(products, 1));

        // 6. Нажать на кнопку сравнить товары
        wait.until(elementToBeClickable(xpath("//a/span[text()='Сравнить']"))).click();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        List<WebElement> comparedProducts = wait.until(numberOfElementsToBeMoreThan(cssSelector("[data-tid='412661c'] a.cia-cs"), 1));
        List<String> comparedProductNames = comparedProducts.stream().map(WebElement::getText).collect(Collectors.toList());

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

    private String addProductToCompare(List<WebElement> products, int productNumber) {
        WebElement addToCompare = wait.until(presenceOfNestedElementLocatedBy(products.get(productNumber),
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        actions
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return wait.until(visibilityOf(products.get(productNumber)
                .findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }
}
