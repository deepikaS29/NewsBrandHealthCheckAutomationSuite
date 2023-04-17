import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/feature/homepage.feature",
        //glue=  {"com.example.StepDefinition"},
        plugin = {"pretty:STDOUT", "html:target/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt"},
        //tags="@login-page",
        dryRun = false

)
public class Runner {

}

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features ={"src/test/resources/features"},
//        //glue = {"com.example.StepDefinition"},
//        plugin = {"pretty:STDOUT",
//                "json:target/cucumber.json",
//                "html:target/cucumber-html-report.html",
//        }
//)
//public class Runner {
//}