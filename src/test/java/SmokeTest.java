import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import runners.DefaultRunner;
import utils.listeners.InvocationListener;
import utils.listeners.TestResultsListener;
import utils.testrail.TestRailAnnotation;

import static com.codeborne.selenide.Selenide.$x;


//@Listeners(TestResultsListener.class)
@Listeners(InvocationListener.class)
public class SmokeTest extends DefaultRunner {

    private final String SNEAKERS_MODEL_FOR_SEARCHING = "Nike Sb Zoom Blazer Mid 864349-107";

    @Test
    @TestRailAnnotation.TestRail(testId = 1)
    public void verifyMakeOrder() throws InterruptedException {
        new BasePage()
                .openHomePage()
                .selectCategories(SNEAKERS_MODEL_FOR_SEARCHING)
                .submit();

        Thread.sleep(5000);

        var soft = new SoftAssertions();

        soft.assertThat($x("//h1[@class='product__title']").getValue())
                .as("")
                .contains(SNEAKERS_MODEL_FOR_SEARCHING);

        soft.assertThat($x("//div[@class='product-about']").isDisplayed())
                .as("Product about should be visible")
                .isFalse();

        soft.assertThat($x("//div[@class='product-about']").isDisplayed())
                .as("Product about should be visible")
                .isFalse();

        soft.assertThat($x("//span[@class='buy-button__label ng-star-inserted']").isDisplayed())
                .as("The 'Buy' button should be visible")
                .isTrue();
        soft.assertAll();
    }

    @Test
    @TestRailAnnotation.TestRail(testId = 2)
    @Description("Custom description")
    public void firstTest() {
        openPage();
    }

    @Step("Open page Allure annotation")
    public void openPage() {
        Selenide.open("https://rozetka.com.ua/ua/");
        //Assert.assertFalse($x("//img[@alt='Rozetka Logo']").isDisplayed());
    }
}
