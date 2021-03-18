package ru.levelup.qa.at.selenuim.page.object.page.elements;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.page.object.page.elements.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.object.page.elements.YandexMarketComparePage;
import ru.levelup.qa.at.selenium.page.object.page.elements.YandexMarketHomePage;
import ru.levelup.qa.at.selenium.page.object.page.elements.YandexMarketProductsPage;
import ru.levelup.qa.at.selenuim.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PageObjectPageElementsTest extends AbstractSeleniumBaseTest {

    @Test
    public void yandexMarketPageObjectTest() {
        // 1. Открыть Яндекс маркет
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver).open();

        // 2. Выбрать категорию "Компьютеры"
        YandexMarketCategoryPage categoryPage = homePage.openCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        YandexMarketProductsPage productsPage = categoryPage.openSubCategory("Ноутбуки");

        // 4. Добавить первый товар к сравнению
        String firstProductName = productsPage
                .getProduct(0)
                .clickAddToCompareButton()
                .getTitle();

        // 5. добавить второй товар к сравнению
        String secondProductName = productsPage
                .getProduct(8)
                .clickAddToCompareButton()
                .getTitle();

        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));

        // 6. Нажать на кнопку сравнить товары
        YandexMarketComparePage comparePage = productsPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        List<String> comparedProductNames = comparePage.getProductTitles();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
