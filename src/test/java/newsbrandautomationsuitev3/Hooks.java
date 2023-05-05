package newsbrandautomationsuitev3;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.CommonLibrary;


public class Hooks extends CommonLibrary {

    @Before
    public void beforeMethod() {
        openBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screen shot"); //stick it in the report
            //scenario.attach()
        }
        closeBrowser();
    }

}
