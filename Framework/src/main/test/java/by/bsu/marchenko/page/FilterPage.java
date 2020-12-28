package by.bsu.marchenko.page;

import by.bsu.marchenko.wait.UsedWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private String pageUrl;

    public FilterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//a[@href='?category=6493']")
    private WebElement actionsForCats;

    @Override
    public FilterPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("Landing page opened");
        return this;
    }

}
