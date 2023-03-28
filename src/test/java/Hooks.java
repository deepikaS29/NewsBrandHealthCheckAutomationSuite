import io.cucumber.java.After;
import io.cucumber.java.Before;
import Utility.CommonLibrary;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends CommonLibrary {

    @Before
    public void beforeMethod() {
        openBrowser();
    }

   // @After
   // public void afterMethod() {
        //closeBrowser();
   // }

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
