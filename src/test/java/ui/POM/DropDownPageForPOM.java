package ui.POM;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.DropDownPage;
import pages.HomePage;


class DropDownPageTestsForPOM extends BasePageTest {

    HomePage homePage;
    DropDownPage dropDownPage;

    @BeforeEach
    void setupPage(){
        HomePage homePage = new HomePage(driver);
        dropDownPage = new DropDownPage(driver);

        homePage.open();
        homePage.openDropDownPage();
    }

    @Step("Check dropdown1")
    @Test
    void checkDropdown1Test(){
        WebElement dropdown1 = dropDownPage.findDropdown();
        dropdown1.click();

        Assertions.assertTrue(dropDownPage.findDropdownMenu().isDisplayed());
    }

    @Step("Check dropdown2")
    @Test
    void checkDropdown2Test() {
        Actions actions = new Actions(driver);
        WebElement dropdown2 = dropDownPage.findDropdown2();

        actions.contextClick(dropdown2).perform();
        Assertions.assertTrue(dropDownPage.findDropdownMenu1().isDisplayed());
    }

    @Step("Check dropdown3")
    @Test
    void checkDropdown3Test() {
        Actions actions = new Actions(driver);
        WebElement dropdown3 = dropDownPage.findDropdown3();

        actions.doubleClick(dropdown3).perform();
        Assertions.assertTrue(dropDownPage.findDropdownMenu2().isDisplayed());
    }

}
