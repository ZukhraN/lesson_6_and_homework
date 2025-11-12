package znurmanova.pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    protected static final String BASE_URL="https://bonigarcia.dev/selenium-webdriver-java/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    //actions
    public void open() {
        driver.get(BASE_URL);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    //methods -> open another PO



}
