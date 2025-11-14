package znurmanova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebFormPage {
    WebDriver driver;
    private static final String WEB_FORM_URL = "web-form.html";

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get title of page")
    public WebElement getTitle() {
        return driver.findElement(By.className("display-6"));
    }

    @Step("Get URL")
    public String getUrl() {
        return WEB_FORM_URL;
    }
}
