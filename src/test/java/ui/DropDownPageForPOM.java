package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropDownPageForPOM {

    @Test
    void dropDowmPage() throws InterruptedException{

        WebElement dropDownPage = driver.findElement(By.xpath("//a[@href='dropdown-menu.html']"));
        dropDownPage.click();
        assertEquals("Dropdown menu", driver.findElement(By.className("display-6")).getText());

        Actions actions = new Actions(driver);
        WebElement dropdown1 = driver.findElement(By.id("my-dropdown-1"));
        dropdown1.click();
        Assertions.assertTrue(driver.findElement(By.cssSelector("ul.dropdown-menu.show")).isDisplayed());

        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdown2).perform();
        Assertions.assertTrue(driver.findElement(By.id("context-menu-2")).isDisplayed());

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).perform();
        Assertions.assertTrue(driver.findElement(By.id("context-menu-3")).isDisplayed());

    }

}
