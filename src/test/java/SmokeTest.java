import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import runners.DefaultRunner;
import utils.testrail.TestRailAnnotation;

import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertFalse;

//@Listeners(TestResultsListener.class)
//@Listeners(InvocationListener.class)
public class SmokeTest extends DefaultRunner {

    private final String SNEAKERS_MODEL_FOR_SEARCHING = "Nike Sb Zoom Blazer Mid 864349-107";

    @Test
    @TestRailAnnotation.TestRail(testId = 1)
    public void verifyMakeOrderOption() throws InterruptedException {
        new BasePage()
                .openHomePage()
                .selectCategories(SNEAKERS_MODEL_FOR_SEARCHING)
                .submit();
        
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
    @Description("Logo is present test")
    public void verifyLogoIsVisible() {
        new BasePage()
                .openHomePage();
        assertFalse($x("//img[@alt='Rozetka Logo']").isDisplayed());
    }
}
