package utils.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static org.openqa.selenium.OutputType.BYTES;

public class AllureListener {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot1() {
       // if (hasWebDriverStarted()) {
            return screenshot(BYTES);
        //}

       // return null;
    }
}
