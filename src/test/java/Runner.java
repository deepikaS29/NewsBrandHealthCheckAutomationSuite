import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.Arrays;
import java.util.List;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/feature/homepage.feature",
//        //glue=  {"com.example.StepDefinition"},
//        plugin = {"pretty:STDOUT", "html:target/cucumber-html-report.html", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt"},
//        //tags="@login-page",
//        dryRun = false
//
//)
//public class Runner {
//
//}

public class Runner {
    // add this method to generate the JUnit test result file
    @AfterClass
    public static void generateJUnitResult() {
        File file = new File("target/cucumber.xml");
        List<String> args = Arrays.asList(
                "--plugin", "junit:" + file.getAbsolutePath(),
                "--glue", "com.example.StepDefinition",
                "src/test/feature/homepage.feature"
        );
        io.cucumber.core.cli.Main.run(args.toArray(new String[0]), Thread.currentThread().getContextClassLoader());
    }
}