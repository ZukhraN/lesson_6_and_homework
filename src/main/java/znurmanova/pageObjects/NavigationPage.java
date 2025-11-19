package znurmanova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends BasePage {

    private static final String NAV_URL = "navigation1.html";

    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Next")
    private WebElement nextButton;
    //private WebElement nextButton = driver.findElement(By.linkText("Next"));

    //locators
    By pText = By.className("lead");
    By buttonNext = By.xpath("//a[text()='Next']");

    //methods
    @Step("Get nav url")
    public String getUrl() {
        return NAV_URL;
    }

    @Step("Find element p")
    public WebElement findPText(){
        return  driver.findElement(pText);
    }

    @Step("Find element button Next")
    public WebElement findButtonNext(){
        return  driver.findElement(buttonNext);
    }

    @Step("Click on the next button")
    public void clickNextButton(){
        nextButton.click();
    }
}
