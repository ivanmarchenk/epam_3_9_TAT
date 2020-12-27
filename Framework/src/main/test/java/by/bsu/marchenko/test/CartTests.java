package by.bsu.marchenko.test;

import by.bsu.marchenko.model.Product;
import by.bsu.marchenko.page.ItemsPage;
import by.bsu.marchenko.service.ProductCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    private Product product = ProductCreator.withNameAndUrlFromProperty();

    @Test
    public void addItemToCartTest(){
        String expectedItemName = "Cat House Когтеточка-лежанка, 55 см, сизаль";
        String actualItemName = new ItemsPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .buttonGoToBasketClick()
                .getItemName();
        assertThat(actualItemName, is(equalTo(expectedItemName)));
    }

    @Test
    public void deleteItemFromCartTest(){
        String expectedCartFieldText = "Товар не добавлен, выберите";
        String actualCartFieldText = new ItemsPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .buttonGoToBasketClick()
                .buttonDeleteItemFromCartClick()
                .buttonAlertWindowAcceptClick()
                .getTextFromCartField();
        assertThat(actualCartFieldText, is(equalTo(expectedCartFieldText)));
    }

    @Test
    public void increaseNumberOfItemsInCartTest(){
        String expectedCountItems = "2";
        String actualCountItems = new ItemsPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .buttonGoToBasketClick()
                .buttonIncreaseNumberOfItemsClick()
                .getTextFromViewCountItems();
        assertThat(actualCountItems, is(equalTo(expectedCountItems)));
    }

}
