package steps;

import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import java.io.IOException;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;

public class AllureSteps {

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Capture screenshot with Selenide")
    public byte[] captureScreenshotSelenide(){
        return Selenide.screenshot(OutputType.BYTES);
    }

}
