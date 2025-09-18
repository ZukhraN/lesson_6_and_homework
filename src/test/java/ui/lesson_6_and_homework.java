package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.findElement(By.xpath("//form")).submit();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
