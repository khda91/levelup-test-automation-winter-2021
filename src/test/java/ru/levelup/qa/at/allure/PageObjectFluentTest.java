package ru.levelup.qa.at.allure;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelup.qa.at.allure.listeners.AllureListener;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@Listeners({AllureListener.class})
public class PageObjectFluentTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp(ITestContext context) {
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(options);
        context.setAttribute("driver", driver);
    }

    @Test
    public void yandexMarketPageObjectTest() {

        YandexMarketProductsPage productsPage = new YandexMarketHomePage(driver)
                .open()                                                         // 1. Открыть Яндекс маркет
                .openCategory("Компьютеры")                                     // 2. Выбрать категорию "Компьютеры"
                .openSubCategory("Ноутбуки");                                   // 3. Выбрать подкатегорию "Ноутбуки"

        // 4. Добавить первый товар к сравнению
        String firstProductName = productsPage.addProductToCompare(0);
        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        List<String> comparedProductNames = productsPage.clickCompareButton()  // 6. Нажать на кнопку сравнить товары
                .getProductTitles();                                //7. Проверить, что выбранные товары были добавлены к сравнению

        assertAddedProductsToCompareList(comparedProductNames, selectedProductNames);
    }

    @Test
    public void yandexMarketPageObjectBrokenTest() {

        YandexMarketProductsPage productsPage = new YandexMarketHomePage(driver)
                .open()                                                         // 1. Открыть Яндекс маркет
                .openCategory("Компьютеры")                                     // 2. Выбрать категорию "Компьютеры"
                .openSubCategory("Ноутбуки1");                                   // 3. Выбрать подкатегорию "Ноутбуки"

        // 4. Добавить первый товар к сравнению
        String firstProductName = productsPage.addProductToCompare(0);
        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        List<String> comparedProductNames = productsPage.clickCompareButton()  // 6. Нажать на кнопку сравнить товары
                .getProductTitles();                                //7. Проверить, что выбранные товары были добавлены к сравнению

        assertAddedProductsToCompareList(comparedProductNames, selectedProductNames);
    }

    @Test
    public void yandexMarketPageObjectFailedTest() {

        YandexMarketProductsPage productsPage = new YandexMarketHomePage(driver)
                .open()                                                         // 1. Открыть Яндекс маркет
                .openCategory("Компьютеры")                                     // 2. Выбрать категорию "Компьютеры"
                .openSubCategory("Ноутбуки");                                   // 3. Выбрать подкатегорию "Ноутбуки"

        // 4. Добавить первый товар к сравнению
        String firstProductName = productsPage.addProductToCompare(0);
        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        List<String> comparedProductNames = productsPage.clickCompareButton()  // 6. Нажать на кнопку сравнить товары
                .getProductTitles();                                //7. Проверить, что выбранные товары были добавлены к сравнению

        assertAddedProductsToCompareList(comparedProductNames, Collections.emptyList());
    }

    @Step("Проверка, что добавленные товары к сравнению совпадают с выбранными товарами")
    private void assertAddedProductsToCompareList(List<String> comparedProductNames, List<String> selectedProductNames) {
        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray()));
    }
}
