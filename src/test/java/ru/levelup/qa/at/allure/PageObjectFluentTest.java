package ru.levelup.qa.at.allure;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PageObjectFluentTest extends AbstractSeleniumBaseTest {

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

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

    @Test
    public void yandexMarketPageObjectFailedTest() {

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

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
