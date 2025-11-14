package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import znurmanova.pageObjects.HomePage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmitPageForPOM extends BaseTests {

    HomePage homePage = new HomePage(driver);

    void openHomePageTest(){

        homePage.open();
        String actualTitle = homePage.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void submitForm() throws InterruptedException {
        WebElement webFormButton = driver.findElement(By.xpath("//a[@href='web-form.html']"));
        Thread.sleep(1000);
        webFormButton.click();
;
        //driver.findElement(By.xpath("//form")).submit();
        //Thread.sleep(3000);
        //driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select select = new Select(selectElement);
        String actualText = select.getFirstSelectedOption().getText();
        assertEquals("Open this select menu", actualText);

        select.selectByIndex(2);
        assertEquals("Two", select.getFirstSelectedOption().getText());

        select.selectByValue("3");
        assertEquals("Three", select.getFirstSelectedOption().getText());

        List<WebElement> selected = select.getAllSelectedOptions();
        assertEquals(1, selected.size());

        List<WebElement> options = select.getOptions();
        assertEquals(4, options.size());

    }

    @Test
    void inputsTextTest() throws InterruptedException{

        WebElement webFormButton = driver.findElement(By.xpath("//a[@href='web-form.html']"));
        Thread.sleep(1000);
        webFormButton.click();

        WebElement inputText = driver.findElement(By.xpath("//input[@name='my-text']"));
        inputText.click();
        inputText.sendKeys("Test text");

        WebElement inputTextPassword = driver.findElement(By.xpath("//input[@name='my-password']"));
        inputTextPassword.click();
        inputTextPassword.sendKeys("password");

        WebElement inputTextArea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        inputTextArea.click();
        inputTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");

        assertEquals("Test text", inputText.getDomProperty("value"));
        assertEquals("password", inputTextPassword.getDomProperty("value"));
        assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo", inputTextArea.getDomProperty("value"));
    }

    @Test
    void inputTextTest() throws InterruptedException{

        WebElement webFormButton = driver.findElement(By.xpath("//a[@href='web-form.html']"));
        Thread.sleep(1000);
        webFormButton.click();

        WebElement inputText = driver.findElement(By.xpath("//input[@name='my-text']"));
        inputText.click();
        inputText.sendKeys("Test text");

        assertEquals("Test text", inputText.getDomProperty("value"));

        WebElement disableInput = driver.findElement(By.name("my-disabled"));
        assertEquals("true", disableInput.getDomAttribute("disabled"));

        WebElement readonlyInput = driver.findElement(By.name("my-readonly"));
        assertEquals("true", readonlyInput.getDomAttribute("readonly"));

        WebElement selectOption = driver.findElement(By.className("form-select"));
        Select select = new Select(selectOption);
        select.selectByIndex(2);
        assertEquals("Two", select.getFirstSelectedOption().getText());

        WebElement inputCity = driver.findElement(By.name("my-datalist"));
        inputCity.sendKeys("Seattle");
        WebElement dataList = driver.findElement(By.id("my-options"));
        List<WebElement> options = dataList.findElements(By.tagName("option"));

        for (WebElement option: options){
            System.out.println(option.getDomProperty("value"));
        }

        String currentSelected = inputCity.getDomProperty("value");
        assertEquals("Seattle", currentSelected);


        File uploadFile = new File("src/test/resources/file.jpg");
        WebElement fileInput = driver.findElement(By.name("my-file"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());


        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        Assertions.assertTrue(checkbox.isSelected(), "Чекбокс должен быть выбран");


        WebElement radio = driver.findElement(By.xpath("//input[@type='radio']"));
        if (!radio.isSelected()){
            radio.click();
        }
        Assertions.assertTrue(radio.isSelected(), "Радиобатон должен быть выбран");


        WebElement colors = driver.findElement(By.name("my-colors"));
        colors.sendKeys("#00ff00");


        WebElement dateInput = driver.findElement(By.name("my-date"));
        dateInput.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".datepicker-days")));

        WebElement dayToSelect = driver.findElement(By.xpath("//td[@class='day' and text()='29']"));
        dayToSelect.click();

        String value = dateInput.getAttribute("value");
        System.out.println("Выбранная дата: " + value);
        Assertions.assertTrue(value.contains("29"));


        WebElement rangeSlider = driver.findElement(By.name("my-range"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = 10; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));",
                rangeSlider
        );


        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        String currentUrl = driver.getCurrentUrl();

        Assertions.assertTrue(currentUrl.contains("my-text=Test+text"));
        Assertions.assertTrue(currentUrl.contains("my-select=2"));
        Assertions.assertTrue(currentUrl.contains("my-datalist=Seattle"));
        Assertions.assertTrue(currentUrl.contains("my-file=file.jpg"));
        Assertions.assertTrue(currentUrl.contains("my-colors=%2300ff00"));
        Assertions.assertTrue(currentUrl.contains("&my-range=10"));

    }



}
