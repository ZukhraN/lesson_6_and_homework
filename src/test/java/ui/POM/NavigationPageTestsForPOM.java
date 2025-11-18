package ui.POM;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.NavigationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class NavigationPageTestsForPOM extends BasePageTest{

    HomePage homePage;
    NavigationPage navigationPage;

    @BeforeEach
    void setupPage(){
        HomePage homePage = new HomePage(driver);
        navigationPage = new NavigationPage(driver);

        homePage.open();
        homePage.openNavigationPage();
    }

    @Step("Open navigation page")
    @Test
    void openNavigationTest(){
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        assertEquals(homePage.BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());

    }

    @Step("Find exact word")
    @Test
    void navigationCheckTextTests(){
        WebElement pText = navigationPage.findPText();
        assertTrue(pText.getText().contains("Lorem"), "Текст элемента не содержит слово 'Lorem'");
    }

    @Step("Check of pushing on the buttons")
    @Test
    void checkPaginationTest() {
        WebElement button = navigationPage.findButtonNext();
        Actions actions = new Actions(driver);

        String initialColor = button.getCssValue("background-color");
        actions.moveToElement(button).perform();
        String currentColor = button.getCssValue("background-color");

        assertNotEquals(initialColor, currentColor, "Цвет кнопки не поменялся при наведении");
    }
}
