import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/feature/homepage.feature",
        //glue=  {"com.example.StepDefinition"},
        plugin = {"pretty:STDOUT", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt"},
        //tags="@login-page",
        dryRun = false

)
public class Runner {

}