package newsbrandautomationsuitev3;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("newsbrandautomationsuitev3")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@IncludeTags("Home-page-menu")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value="junit:target/cucumber-reports/Cucumber.xml, json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/Cucumber.html, timeline:target/cucumber-reports/CucumberTimeline")
public class RunCucumberTest {
}
