package selenium_tests.TestRun;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/selenium_tests/features",
        glue = {"selenium_tests.stepdefinition"},
        plugin = {"pretty"}
)

public class SeleniumTests {
}
