package pageobjects;

import io.qameta.allure.Step;
import runners.DefaultRunner;

import static com.codeborne.selenide.Selenide.open;
import static utils.AppConfig.getAppLoginUrl;

public class BasePage extends DefaultRunner {

    @Step("Opened home page")
    public HomePage openHomePage(){
        open(getAppLoginUrl());
        return new HomePage();
    }
}
