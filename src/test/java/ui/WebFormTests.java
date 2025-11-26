package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class WebFormTests extends BasePageTests {

    @Step("Open web form")
    @Test
    void openWebForm(){

        String webFormUrl = "web-form.html";
        driver.findElement(By.linkText("Web form")).click();

        String currentUrl =driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

    }

    @Step("Check text area")
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

    @Step("Check disabled input")
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
