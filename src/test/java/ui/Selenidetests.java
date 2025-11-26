package ui;
import com.codeborne.selenide.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.WebFormPage;
import steps.AllureSteps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Selenidetests {
    AllureSteps allureSteps = new AllureSteps();

    @Test
    void openHomePageTest(){
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/");

        Assertions.assertEquals("Hands-On Selenium WebDriver with Java",Selenide.title());
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", WebDriverRunner.url());
    }

    @Test
    void successfulLoginTest(){
        open("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");

        SelenideElement subTitle = $(By.className("display-6"));
        WebElement loginInput = $(("#username"));
        WebElement passwordInput = $("#password");
        WebElement submitButton = $(By.xpath("//button[@type='submit']"));

        loginInput.sendKeys("user");
        passwordInput.sendKeys("user");
        String textBeforeClick = subTitle.getText();
        submitButton.click();

        assertThat(textBeforeClick).isEqualTo( "Login form");
        subTitle.shouldHave(text("Login form"));
        subTitle.should(visible);
        WebElement successMessage = $("#success");
        assertThat(successMessage.isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Check screenshot attachment")
    void infinityScrollWithAttachTest() throws InterruptedException {
        open("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        WebDriver driver = Selenide.webdriver().object();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By pLocator = By.tagName("p");
        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, 0));
        int initParagraphsNumber = paragraphs.size();

        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]", initParagraphsNumber)));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script, lastParagraph);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, initParagraphsNumber));
        Thread.sleep(3000);
        allureSteps.captureScreenshotSelenide();
    }

    @Test
    void loadingImagesWithTimeOutTest(){
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        Configuration.timeout = 9_000;
        $("#landscape").shouldHave(visible);
    }

    @Test
    void loadingImagesWithExplicitTimeOutTest(){
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        ElementsCollection images = $$(byXpath("//div/img")).filter(visible);
        images.shouldHave(size(4), Duration.ofSeconds(10));
    }

    @Test
    void pageObjectTest(){
        HomePage homePage = new HomePage();
        homePage.openPage();
        WebFormPage webFormPage = homePage.openWebFormPage();

        $(byXpath("//h1[@class='display-6']")).shouldHave((text("Web form")));
    }
}
