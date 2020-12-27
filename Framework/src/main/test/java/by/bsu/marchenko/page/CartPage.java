package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final String cartMessage = "//span[@class='basket_title']";
    private static final int WAIT_TIMEOUT_SECONDS = 10;


    @FindBy(xpath = "//a[@class='basket_delete_button']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//a[@class='basket_plus']")
    private WebElement buttonIncreaseNumberOfItems;

    @FindBy(xpath = "//input[@class='basket_quantity_input']")
    private WebElement viewCountItems;

    @FindBy(xpath = "//span[@class='navigation_button' and text()='Перейти в корзину']")
    private WebElement goToBasket;

    @FindBy(className = "product-card__title")
    private WebElement item;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getItemName(){
        return UsedWait.waitWebElement(driver, item).getText();
    }

    public CartPage buttonDeleteItemFromCartClick(){
        UsedWait.waitWebElement(driver, buttonDelete).click();
        return this;
    }

    public CartPage buttonGoToBasketClick(){
        UsedWait.waitWebElement(driver, goToBasket).click();
        return this;
    }

    public ItemsPage buttonAlertWindowAcceptClick(){
        driver.switchTo().alert().accept();
        return new ItemsPage(driver);
    }

    public CartPage buttonIncreaseNumberOfItemsClick(){
        UsedWait.waitWebElement(driver, buttonIncreaseNumberOfItems).click();
        return this;
    }

    public String getTextFromViewCountItems(){
        return UsedWait.waitWebElement(driver, viewCountItems).getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public String getCartCountMessage() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(cartMessage)))
                .getText();
    }
}
