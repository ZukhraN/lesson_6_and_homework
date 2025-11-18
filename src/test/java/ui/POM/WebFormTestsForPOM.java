package ui.POM;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class WebFormTestsForPOM extends BasePageTest {

    HomePage homePage;
    WebFormPage webFormPage;

    @BeforeEach
    void setupPage(){
        HomePage homePage = new HomePage(driver);
        webFormPage = new WebFormPage(driver);

        homePage.open();
        homePage.openWebFormPage();
    }

    @Step("Open web from page")
    @Test
    void openWebFormTest(){
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(homePage.BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

    }

    @Step("Check text area input")
    @Test
    void checkTextAreaInput(){
        webFormPage.getTextarea().sendKeys("Test text");
        webFormPage.getSubmitButton().click();
        WebElement titleH = webFormPage.getTitleH1();

        assertEquals("Form submitted", titleH.getText());
    }

    @Step("Check disabled input")
    @Test
    void disabledInput(){
        webFormPage.disabledField();
        assertEquals("", webFormPage.disabledField().getText());

        Exception thrown = assertThrows(ElementNotInteractableException.class, ()-> webFormPage.disabledField().sendKeys("Test\n"));
        assertThat(thrown.getMessage().contains("element not interactable"));
    }
}
