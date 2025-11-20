package znurmanova.selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static znurmanova.pageObjects.HomePage.BASE_URL;

public class HomePage extends BasePage{
    @Step("Open home page")
    public void open(){
        Selenide.open(BASE_URL, HomePage.class);
    }

    @Step("Open web from page")
    public WebFormPage openWebFormPage(){
        $(By.linkText("Web form")).click();
        return page(WebFormPage.class);
    }
}
