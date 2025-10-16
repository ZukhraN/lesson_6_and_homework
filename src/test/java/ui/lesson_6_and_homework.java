package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class lesson_6_and_homework {

    private static final String BASE_URL="https://bonigarcia.dev/selenium-webdriver-java/";
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown(){
        driver.close();
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
        Assertions.assertEquals("Open this select menu", actualText);

        select.selectByIndex(2);
        Assertions.assertEquals("Two", select.getFirstSelectedOption().getText());

        select.selectByValue("3");
        Assertions.assertEquals("Three", select.getFirstSelectedOption().getText());

        List<WebElement> selected = select.getAllSelectedOptions();
        Assertions.assertEquals(1, selected.size());

        List<WebElement> options = select.getOptions();
        Assertions.assertEquals(4, options.size());

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

        Assertions.assertEquals("Test text", inputText.getDomProperty("value"));
        Assertions.assertEquals("password", inputTextPassword.getDomProperty("value"));
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo", inputTextArea.getDomProperty("value"));
    }

    @Test
    void inputTfextTest() throws InterruptedException{

        WebElement webFormButton = driver.findElement(By.xpath("//a[@href='web-form.html']"));
        Thread.sleep(1000);
        webFormButton.click();

        WebElement inputText = driver.findElement(By.xpath("//input[@name='my-text']"));
        inputText.click();
        inputText.sendKeys("Test text");

        Assertions.assertEquals("Test text", inputText.getDomProperty("value"));

        WebElement disableInput = driver.findElement(By.name("my-disabled"));
        Assertions.assertEquals("true", disableInput.getDomAttribute("disabled"));

        WebElement readonlyInput = driver.findElement(By.name("my-readonly"));
        Assertions.assertEquals("true", readonlyInput.getDomAttribute("readonly"));

        WebElement selectOption = driver.findElement(By.className("form-select"));
        Select select = new Select(selectOption);
        select.selectByIndex(2);
        Assertions.assertEquals("Two", select.getFirstSelectedOption().getText());

        WebElement inputCity = driver.findElement(By.name("my-datalist"));
        inputCity.sendKeys("Seattle");
        WebElement dataList = driver.findElement(By.id("my-options"));
        List<WebElement> options = dataList.findElements(By.tagName("option"));

        for (WebElement option: options){
            System.out.println(option.getDomProperty("value"));
        }

        String currentSelected = inputCity.getDomProperty("value");
        Assertions.assertEquals("Seattle", currentSelected);
    }


}
