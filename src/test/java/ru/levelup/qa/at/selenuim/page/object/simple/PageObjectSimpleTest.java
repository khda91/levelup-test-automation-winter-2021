package ru.levelup.qa.at.selenuim.page.object.simple;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.page.object.simple.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.object.simple.YandexMarketComparePage;
import ru.levelup.qa.at.selenium.page.object.simple.YandexMarketHomePage;
import ru.levelup.qa.at.selenium.page.object.simple.YandexMarketProductsPage;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PageObjectSimpleTest extends AbstractSeleniumBaseTest {

    @Test
    public void yandexMarketPageObjectTest() {
        // 1. Открыть Яндекс маркет
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver).open();

        // 2. Выбрать категорию "Компьютеры"
        YandexMarketCategoryPage categoryPage = homePage.openCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        YandexMarketProductsPage productsPage = categoryPage.openSubCategory("Ноутбуки");

        // 4. Добавить первый товар к сравнению
        String firstProductName = productsPage.addProductToCompare(0);
        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        // 6. Нажать на кнопку сравнить товары
        YandexMarketComparePage comparePage = productsPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        List<String> comparedProductNames = comparePage.getProductTitles();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
