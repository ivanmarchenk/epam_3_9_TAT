package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String productUrl;

    @FindBy(xpath = "//div[@id='bx_117848907_109255_basket_actions']")
    private WebElement buttonAddItemToCart;

    @FindBy(xpath = "//div[@class='top']//span[@class='top_korz']")
    private WebElement cartField;

    public ItemsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemsPage(WebDriver driver, String productUrl){
        super(driver);
        this.productUrl = productUrl;
        PageFactory.initElements(this.driver, this);
    }

    public CartPage buttonAddItemToCartClick(){
        UsedWait.waitWebElement(driver, buttonAddItemToCart).click();
        return new CartPage(driver);
    }

    public String getTextFromCartField(){
        return UsedWait.waitWebElement(driver, cartField).getText();
    }

    @Override
    public ItemsPage openPage() {
        driver.navigate().to(productUrl);
        logger.info("Item page opened");
        return this;
    }
}
