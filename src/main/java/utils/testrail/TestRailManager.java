package utils.testrail;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.List;


public class TestRailManager {

    public static int TEST_RUN_PROJECT_ID = 1;
    public static String TESTRAIL_USERNAME = "solomiyariznuchok@gmail.com";
    public static String TESTRAIL_PASSWORD = "1234qwertY!";
    public static String RAILS_ENGINE_URL = "https://pet1.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    private static final String projectName = "Pet_project";


    public static TestRail addResultForTestCase() {
        return TestRail
                .builder(RAILS_ENGINE_URL, TESTRAIL_USERNAME, TESTRAIL_PASSWORD)
                .applicationName(projectName)
                .build();
    }

    public void setTestResult(ITestResult context) {
        TestRail testRail = addResultForTestCase();
        Run run = testRail
                .runs()
                .add(TEST_RUN_PROJECT_ID, new Run().setName("Weekly Regression"))
                .execute();

        List<ResultField> customResultFields = testRail
                .resultFields()
                .list()
                .execute();

        testRail
                .results()
                .addForCase(run.getId(), getMethodTestRailId(context), new Result()
                        .setStatusId(getTestRailFailCode(context)), customResultFields)
                .execute();
    }

    public static int getTestRailFailCode(ITestResult context) {
        if (context.isSuccess()) {
            System.out.println("at least one test failed");

            return TEST_CASE_PASSED_STATUS;
        } else {
            System.out.println("all tests were success");

            return TEST_CASE_FAILED_STATUS;
        }
    }

    public int getMethodTestRailId(ITestResult context) {
        Method[] methods = context.getTestClass().getRealClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(TestRailAnnotation.TestRail.class)) {
                TestRailAnnotation.TestRail annotation = m.getAnnotation(TestRailAnnotation.TestRail.class);
                return annotation.testId();

            }
        }
        return 0;
    }
}
