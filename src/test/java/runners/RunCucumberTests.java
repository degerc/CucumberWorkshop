package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(glue={"steps"}, features = "src/resources", plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json" })

public class RunCucumberTests {
}
