package ui;


import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import znurmanova.pageObjects.DragAndDropPage;
import znurmanova.pageObjects.HomePage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropPageTestsForPOM extends BasePageTests {

    HomePage homePage;
    DragAndDropPage dragAndDropPage;

    @BeforeEach
    void setupPage(){
        homePage = new HomePage(driver);
        dragAndDropPage = new DragAndDropPage(driver);

        homePage.open();
        homePage.openDragAndDropPage();
    }

    @Step("Drag and drop element on the place")
    @Test
    void dragAndDrop(){

        WebElement draggble = dragAndDropPage.findDraggable();
        WebElement target = dragAndDropPage.findTarget();

        assertEquals("Drag and drop", dragAndDropPage.getTitle().getText());

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggble, target).perform();

    }

}
