package znurmanova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebFormPage extends BasePage {

    private static final String WEB_FORM_URL = "web-form.html";

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By title = By.className("display-6");
    By textarea = By.name("my-textarea");
    By submitButton = By.xpath("//button[@type='submit']");
    By titleH1 = By.xpath("//h1[text()='Form submitted']");
    By disabledField = By.name("my-disabled");
    By dropdownSelect = By.name("my-select");
    By textInput = By.xpath("//input[@name='my-text']");
    By passwordInput = By.xpath("//input[@name='my-password']");
    By textArea = By.xpath("//textarea[@name='my-textarea']");

    //methods

    @Step("Get title of page")
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    @Step("Get URL")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("Find element textarea")
    public WebElement getTextarea() {
        return driver.findElement(textarea);
    }

    @Step("Find element submitButton")
    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    @Step("Find element H1")
    public WebElement getTitleH1() {
        return driver.findElement(titleH1);
    }

    @Step("Find element disabledField")
    public WebElement disabledField() {
        return driver.findElement(disabledField);
    }

    @Step("Find element dropdown select")
    public WebElement dropdownSelect() {
        return driver.findElement(dropdownSelect);
    }

    @Step("Find element textInput")
    public WebElement textInput() {
        return driver.findElement(textInput);
    }

    @Step("Find element passwordInput")
    public WebElement passwordInput() {
        return driver.findElement(passwordInput);
    }

    @Step("Find element text area")
    public WebElement textArea() {
        return driver.findElement(textArea);
    }
}
