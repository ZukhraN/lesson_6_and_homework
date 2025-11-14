package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import znurmanova.pageObjects.HomePage;
import znurmanova.pageObjects.WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class WebFormTestsForPOM extends BaseTestsForPOM {

    @Test
    void openWebForm(){

        HomePage homePage = new HomePage(driver);
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();


        assertEquals(homePage.BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

    }

    @Test
    void checkTextAreaInput(){
        String webFormUrl = "web-form.html";
        driver.findElement(By.linkText("Web form")).click();

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("Test text");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Form submitted']"));
        assertEquals("Form submitted", h1.getText());
    }

    @Test
    void disabledInput(){
        String webFormUrl = "web-form.html";
        driver.findElement(By.linkText("Web form")).click();

        WebElement disabled = driver.findElement(By.name("my-disabled"));
        assertEquals("", disabled.getText());
        Exception thrown = assertThrows(ElementNotInteractableException.class, ()-> disabled.sendKeys("Test\n"));
        assertThat(thrown.getMessage().contains("element not interactable"));
    }
}
