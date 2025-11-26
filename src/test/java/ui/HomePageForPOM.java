package ui;

import org.junit.jupiter.api.Test;
import znurmanova.pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageForPOM extends BaseTestsForPOM {


    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

}