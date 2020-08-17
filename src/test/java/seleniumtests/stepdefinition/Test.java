package seleniumtests.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import seleniumtests.steplibrary.LandingStepLib;

public class Test {

  @Steps
   private LandingStepLib landingSteplib;

  @Given("^user lands on google home page$")
  public void userLandsOnGoogleHomePage() {
    landingSteplib.launchGoogle();
  }

  @When("^the user search BJSS$")
  public void theUserSearchBjss() {
    landingSteplib.searchText("bjss");
    Assert.fail("Test Failed");
  }
}
