package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String pageUrl;

    @FindBy(id="title-search-input")
    private WebElement inputField;

    @FindBy(xpath = "//span[@class='bx-input-group-btn']")
    private WebElement buttonSearch;

    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LandingPage(WebDriver driver, String pageUrl){
        super(driver);
        this.pageUrl = pageUrl;
        PageFactory.initElements(this.driver, this);
    }

    public LandingPage insertTextInInputField(String text){
        UsedWait.waitWebElement(driver, inputField).sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
        return this;
    }

    public SearchResultPage buttonSearchClick(){
        UsedWait.waitWebElement(driver, buttonSearch).click();
        return new SearchResultPage(driver);
    }

    @Override
    public LandingPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("Landing page opened");
        return this;
    }
}
