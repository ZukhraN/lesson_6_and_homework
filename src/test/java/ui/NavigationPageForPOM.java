package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationPageForPOM {

    @Test
    void navigationTests() throws InterruptedException {

        WebElement navPage = driver.findElement(By.xpath("//a[@href='navigation1.html']"));
        navPage.click();
        assertEquals("Navigation example", driver.findElement(By.xpath("//h1[@class='display-6']")).getText());

        WebElement textBlock = driver.findElement(By.className("lead"));
        Assertions.assertTrue(textBlock.getText().contains("Lorem ipsum"), "Текст элемента не содержит слово 'Lorem'");

        WebElement nav = driver.findElement(By.className("pagination"));
        WebElement button = driver.findElement(By.xpath("//a[text()='Next']"));
        Actions actions = new Actions(driver);

        String initialColor = button.getCssValue("background-color");
        actions.moveToElement(button).perform();
        String currentColor = button.getCssValue("background-color");

        Assertions.assertNotEquals(initialColor, currentColor, "Цвет кнопки не поменялся при наведении");


    }


}
