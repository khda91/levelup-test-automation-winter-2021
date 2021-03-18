package ru.levelup.qa.at.selenuim.page.object.voids;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.page.object.voids.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.object.voids.YandexMarketComparePage;
import ru.levelup.qa.at.selenium.page.object.voids.YandexMarketHomePage;
import ru.levelup.qa.at.selenium.page.object.voids.YandexMarketProductsPage;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PageObjectVoidTest extends AbstractSeleniumBaseTest {

    @Test
    public void yandexMarketPageObjectTest() {
        // 1. Открыть Яндекс маркет
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.open();

        // 2. Выбрать категорию "Компьютеры"
        homePage.openCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.openSubCategory("Ноутбуки");

        // 4. Добавить первый товар к сравнению
        YandexMarketProductsPage productsPage = new YandexMarketProductsPage(driver);
        String firstProductName = productsPage.addProductToCompare(0);
        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        // 6. Нажать на кнопку сравнить товары
        productsPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        YandexMarketComparePage comparePage = new YandexMarketComparePage(driver);
        List<String> comparedProductNames = comparePage.getProductTitles();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
