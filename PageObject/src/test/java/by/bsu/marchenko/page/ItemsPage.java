package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends Page {
    private final int WAIT_TIME_SECONDS = 10;
    private String pageUrl;

    @FindBy(xpath = "//div[@id='bx_117848907_109255_basket_actions']")
    private WebElement buttonAddItemToCart;

    @FindBy(xpath = "//div[@class='basket_empty_container' and text()='Товар не добавлен, выберите ']")
    private WebElement cartField;

    public ItemsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public ItemsPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LandingPage buttonAddItemToCartClick(){
        UsedWait.waitWebElement(driver, buttonAddItemToCart).click();
        return new LandingPage(driver);
    }
}
