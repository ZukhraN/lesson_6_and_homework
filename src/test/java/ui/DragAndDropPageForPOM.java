package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropPageForPOM extends BasePageTests{

    @Step("Проверка страницы драг энд дроп")
    @Test
    void dragAndDrop(){

        WebElement dragAndDropPage = driver.findElement(By.xpath("//a[@href='drag-and-drop.html']"));
        dragAndDropPage.click();
        assertEquals("Drag and drop", driver.findElement(By.className("display-6")).getText());

        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        actions.dragAndDrop(draggable, target).perform();

    }

}
