package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends Page {
    public static final int WAIT_TIME_SECONDS = 10;
    private String pageUrl;
    private By inputText=By.id("title-search-input");

    @FindBy(className = "bx-nav-1-lvl bx-nav-list-0-col")
    private WebElement action;

    @FindBy(id ="title-search-input")
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
    public LandingPage openPage(String url) {
        driver.get(url);
        return this;
    }
}
