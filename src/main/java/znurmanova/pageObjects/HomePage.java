package znurmanova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public static final String BASE_URL="https://bonigarcia.dev/selenium-webdriver-java/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    //actions
    @Step("Opening BASE URL")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Getting title of page")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Opening Web Form Page")
    //methods -> open another PO
    public WebFormPage openWebFormPage(){
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }


}
