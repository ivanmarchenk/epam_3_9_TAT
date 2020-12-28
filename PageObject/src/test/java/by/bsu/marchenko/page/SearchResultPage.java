package by.bsu.marchenko.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends Page {

    private By viewSearchResultField=By.className("empty_search_result_text");

    public SearchResultPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTextFromViewSearchResultField(){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(viewSearchResultField)).getText();

    }

    @Override
    protected SearchResultPage openPage(String url) {
        return this;
    }
}
