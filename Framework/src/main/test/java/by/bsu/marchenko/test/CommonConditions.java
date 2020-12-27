package by.bsu.marchenko.test;

import by.bsu.marchenko.driver.DriverManager;
import by.bsu.marchenko.util.TestListener;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.closeDriver();
    }
}
