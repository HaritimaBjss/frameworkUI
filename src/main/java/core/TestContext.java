package core;

import org.openqa.selenium.WebDriver;

public class TestContext {
  private static TestContext testContext = new TestContext();
  private static WebDriver webDriver;
  private DriverSetup driverSetup = new DriverSetup();

  private TestContext() {
    if (webDriver == null) {
      webDriver = driverSetup.getDriver();
    }
  }

  public static TestContext getInstance() {
    return testContext;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public void closeAll() {
    webDriver.close();
  }
}
