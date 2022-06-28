package runners;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;

public abstract class BaseRunner {

    protected void setUpBrowser() {
        Configuration.browser = "chrome";
        open("about:blank");

        var driver = getWebDriver();

        driver
                .manage()
                .deleteAllCookies();
        System.out.println("The test was executed in the headless mode");
    }
}