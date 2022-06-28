package pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage<T extends HomePage> {

    private final SelenideElement searchInput = $x("//input");
    private final SelenideElement submitButton = $x("//button[contains(@class, 'button_color_green')]");

    @Step("Selected categories")
    public HomePage selectCategories(String itemToSearch) {
        searchInput.val(itemToSearch);

        return this;
    }

    @Step("Submitted choice")
    public T submit(){
        submitButton.click();
        return (T) this;
    }
}