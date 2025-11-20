package ui;

import znurmanova.configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static znurmanova.patterns.WebDriverFactory.createWebDriver;

class BaseTest {
    WebDriver driver;
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = createWebDriver(configProperties.browser());
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
}
