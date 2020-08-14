package selenium_tests.stepdefinition;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import selenium_tests.steplibrary.LandingStepLib;

public class test {

        @Steps
        private LandingStepLib landingSteplib ;

        @Given("^user is on google home page$")
        public void getGoogle()
        {
                landingSteplib.launchGoogle();
        }
}
