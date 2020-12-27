package by.bsu.marchenko.test;

import by.bsu.marchenko.page.LandingPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductTests extends CommonConditions{
    private static final String LANDING_PAGE_URL = "https://garfield.by/";
    private static final String PRODUCT_SEARCH_NAME = "SOME TEXT";

    @Test
    public void searchNonExistentProduct(){
        String expectedSearchResultText = "Товар не найден. Проверьте название или поищите товар в каталоге.";
        String actualSearchResultText = new LandingPage(driver, LANDING_PAGE_URL)
                .openPage()
                .insertTextInInputField(PRODUCT_SEARCH_NAME)
                .buttonSearchClick()
                .getTextFromViewSearchResultField();
        assertThat(actualSearchResultText, is(equalTo(expectedSearchResultText)));
    }
}
