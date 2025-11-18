package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage extends BasePage{

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By dragAndDrop = By.xpath("//a[@href='drag-and-drop.html']");
    By draggable = By.id("draggable");
    By target = By.id("target");

    //methods
    @Step("Find element dragAndDrop")
    public WebElement findDragAndDrop(){
        return driver.findElement(dragAndDrop);
    }

    @Step("Find element draggable")
    public WebElement findDraggable(){
        return driver.findElement(draggable);
    }

    @Step("Find element target")
    public WebElement findTarget(){
        return driver.findElement(target);
    }
}
