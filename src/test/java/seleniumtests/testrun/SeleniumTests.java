package seleniumtests.testrun;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/seleniumtests/features",
        glue = {"seleniumtests.stepdefinition"},
        plugin = {"pretty"}
)

public class SeleniumTests {
}
