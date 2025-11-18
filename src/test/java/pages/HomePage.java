package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public static final String BASE_URL="https://bonigarcia.dev/selenium-webdriver-java/";
    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //locators

    //actions
    @Step("Opening BASE URL")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Get web title")
    public String getWebTitle(){
        return driver.getTitle();
    }

    //methods -> open another PO
    @Step("Opening Web Form Page")
    public WebFormPage openWebFormPage(){
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }

    @Step("Opening Web Form Page")
    public DragAndDropPage openDragAndDropPage (){
        driver.findElement(By.linkText("Drag and drop")).click();
        return new DragAndDropPage(driver);
    }

    @Step("Opening Dropdown menu Page")
    public DropDownPage openDropDownPage (){
        driver.findElement(By.linkText("Dropdown menu")).click();
        return new DropDownPage(driver);
    }

    @Step("Opening Navigation Page")
    public NavigationPage openNavigationPage (){
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver);
    }
}
