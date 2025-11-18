package znurmanova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By dropdown1 = By.id("my-dropdown-1");
    By dropdownMenu = By.cssSelector("ul.dropdown-menu.show");
    By dropdown2 = By.id("my-dropdown-2");
    By dropdownMenu1 = By.id("context-menu-2");
    By dropdown3 = By.id("my-dropdown-3");
    By dropdownMenu2 =By.id("context-menu-3");

    //methods
    @Step("Find dropdown1")
    public WebElement findDropdown(){
        return driver.findElement(dropdown1);
    }

    @Step("Find menu")
    public WebElement findDropdownMenu(){
        return driver.findElement(dropdownMenu);
    }

    @Step("Find dropdown2")
    public WebElement findDropdown2(){
        return driver.findElement(dropdown2);
    }

    @Step("Find menu")
    public WebElement findDropdownMenu1(){
        return driver.findElement(dropdownMenu1);
    }

    @Step("Find dropdown3")
    public WebElement findDropdown3(){
        return driver.findElement(dropdown3);
    }

    @Step("Find menu")
    public WebElement findDropdownMenu2(){
        return driver.findElement(dropdownMenu2);
    }
}
