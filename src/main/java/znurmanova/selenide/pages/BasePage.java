package znurmanova.selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    @Step("Get web title")
    public String getWebTitle (){
        return Selenide.title();
    }

    @Step("Get current url")
    public String getCurrentUrl(){
        return url();
    }

}
