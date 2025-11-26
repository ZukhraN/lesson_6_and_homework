package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    public void openPage(){
        open("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    public WebFormPage openWebFormPage(){
        $(byXpath("//a[@href='web-form.html']")).click();
        return new WebFormPage();
    }

}
