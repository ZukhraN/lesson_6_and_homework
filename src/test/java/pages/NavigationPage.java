package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage extends BasePage {

    private static final String WEB_FORM_URL = "navigation1.html";

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get URL")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    //locators
    By pText = By.className("lead");
    By buttonNext = By.xpath("//a[text()='Next']");

    //methods
    @Step("Find element p")
    public WebElement findPText(){
        return  driver.findElement(pText);
    }

    @Step("Find element button Next")
    public WebElement findButtonNext(){
        return  driver.findElement(buttonNext);
    }

}
