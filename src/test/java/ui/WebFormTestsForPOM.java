package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import znurmanova.pageObjects.HomePage;
import znurmanova.pageObjects.WebFormPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class WebFormTestsForPOM extends BasePageTest {

    HomePage homePage;
    WebFormPage webFormPage;

    @BeforeEach
    void setupPage(){
        HomePage homePage = new HomePage(driver);
        webFormPage = new WebFormPage(driver);

        homePage.open();
        homePage.openWebFormPage();
    }

    @Step("Open web from page")
    @Test
    void openWebFormTest(){
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(homePage.BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

    }

    @Step("Check text area input")
    @Test
    void checkTextAreaInput(){
        webFormPage.getTextarea().sendKeys("Test text");
        webFormPage.getSubmitButton().click();
        WebElement titleH = webFormPage.getTitleH1();

        assertEquals("Form submitted", titleH.getText());
    }

    @Step("Check disabled input")
    @Test
    void disabledInput(){
        webFormPage.disabledField();
        assertEquals("", webFormPage.disabledField().getText());

        Exception thrown = assertThrows(ElementNotInteractableException.class, ()-> webFormPage.disabledField().sendKeys("Test\n"));
        assertThat(thrown.getMessage().contains("element not interactable"));
    }

    @Step("Check dropdown select")
    @Test
    void submitFormTest(){

        WebElement selectElement = webFormPage.dropdownSelect();
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

    @Step("Check filling text and password inputs")
    @Test
    void inputsTextTest(){
        WebElement inputText = webFormPage.textInput();
        inputText.click();
        inputText.sendKeys("Test text");

        WebElement inputTextPassword = webFormPage.passwordInput();
        inputTextPassword.click();
        inputTextPassword.sendKeys("password");

        WebElement inputTextArea = webFormPage.textArea();
        inputTextArea.click();
        inputTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");

        assertEquals("Test text", inputText.getDomProperty("value"));
        assertEquals("password", inputTextPassword.getDomProperty("value"));
        assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo", inputTextArea.getDomProperty("value"));
    }
/*
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
*/
}
