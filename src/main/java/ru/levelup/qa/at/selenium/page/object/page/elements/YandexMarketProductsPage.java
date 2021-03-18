package ru.levelup.qa.at.selenium.page.object.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.qa.at.selenium.page.object.page.elements.components.ProductComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class YandexMarketProductsPage extends AbstractYandexMarketPage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> productList;

    private List<ProductComponent> products;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketProductsPage(WebDriver driver) {
        super(driver);
        products = new ArrayList<>();
    }

    public String addProductToCompare(int productNumber) {
        products = productList
                .stream()
                .map(elem -> new ProductComponent(driver, elem))
                .collect(Collectors.toList());

        return products
                .get(productNumber)
                .clickAddToCompareButton()
                .getTitle();
    }

    public ProductComponent getProduct(String productName) {
        Optional<ProductComponent> res = productList
                .stream()
                .map(elem -> new ProductComponent(driver, elem))
                .filter(product -> product.getTitle().equals(productName))
                .findFirst();

        if (res.isPresent()) {
            return res.get();
        }

        return null;

//        return productList
//                .stream()
//                .map(elem -> new ProductComponent(driver, elem))
//                .filter(product -> product.getTitle().equals(productName))
//                .findFirst()
//                .orElseGet(null);

    }

    public ProductComponent getProduct(int productNumber) {
        return new ProductComponent(driver, productList.get(productNumber));
    }

    public YandexMarketComparePage clickCompareButton() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(compareButton)).click();
        return new YandexMarketComparePage(driver);
    }
}
