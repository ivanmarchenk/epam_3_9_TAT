package by.bsu.marchenko.test;

import by.bsu.marchenko.page.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {
    private static final String PRODUCT_SEARCH_NAME = "SOME TEXT";
    private static  WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void searchNonExistentProduct(){
        String expectedSearchResultText = "Товар не найден. Проверьте название или поищите товар в каталоге.";
        String actualSearchResultText = new LandingPage(driver)
                .openPage("https://garfield.by/")
                .insertTextInInputField(PRODUCT_SEARCH_NAME)
                .buttonSearchClick()
                .getTextFromViewSearchResultField();
        assertThat(actualSearchResultText, is(equalTo(expectedSearchResultText)));
    }
}
