package runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DefaultRunner extends BaseRunner{

    @BeforeClass(alwaysRun = true)
    public void setupBrowser() {
        super.setUpBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void quitEverything(){
    }
}
