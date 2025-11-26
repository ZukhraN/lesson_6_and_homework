package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import znurmanova.selenide.pages.HomePage;
import znurmanova.selenide.pages.WebFormPage;

import static com.codeborne.selenide.Condition.value;
import static org.testng.Assert.assertEquals;
import static znurmanova.pageObjects.HomePage.BASE_URL;

public class SelenideTests {

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
    }


    @Test
    void openHomePageTest(){
        HomePage homePage = new HomePage();
        homePage.open();

        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @Test
    void openWebFormPAgeTest(){
        HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormExpectedUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest(){
        HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }
}
