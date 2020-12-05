import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class Test {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://garfield.by/catalog/cats/kogtetochki/kompleksy/igrovoy-kompleks-buran-106-sm.html");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @org.testng.annotations.Test
    public void sortingScratchingPostsByCharacteristics () {
        WebElement popElementToBasket = driver.findElement(By.xpath("//div[@id='bx_117848907_109270_basket_actions']"));
        popElementToBasket.click();
        WebElement popupWindowButton = driver.findElement(By.xpath("//div[@class='popup-window-buttons']/span[1]"));
        popupWindowButton.click();
        String confirmedItemTitle = "Cat House Комплекс \"Буран\", 106 см, сизаль Бежевая";
        WebElement itemTitle = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='1418203']/td[3]/h2/text()")));
        String verifiableItemTitle = itemTitle.getText();
        Assert.assertEquals(confirmedItemTitle, verifiableItemTitle);
    }
}
