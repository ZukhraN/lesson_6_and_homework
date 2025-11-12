package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import znurmanova.pageObjects.HomePage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageForPOM extends BaseTestsForPOM {


    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        String actualTitle = homePage.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

}