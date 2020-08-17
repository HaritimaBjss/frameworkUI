package seleniumtests.stepdefinition;

import core.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Hooks {
  private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

  /**
   * clear all the browser.
   */
  @After
  public void afterScenario(Scenario scenario) throws IOException {
    WebDriver driver = TestContext.getInstance().getWebDriver();
    if (scenario.isFailed()) {
      String testName = scenario.getName();
      // Take a screenshot...
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      scenario.embed(Files.readAllBytes(screenshot.toPath()), "image/png");
      scenario.write(testName);
    }
    LOGGER.info("Cleanup browsers");
    TestContext.getInstance().closeAll();
  }
}