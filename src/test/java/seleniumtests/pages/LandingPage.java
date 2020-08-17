package seleniumtests.pages;

import core.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
  private final WebDriver driver;
  private final WebDriverWait wait;


  /** constructor to initialise the webdriver.
   *
   */
  public LandingPage() {
    TestContext context = TestContext.getInstance();
    this.driver = context.getWebDriver();
    PageFactory.initElements(this.driver, this);
    this.wait = new WebDriverWait(this.driver, 10);
  }

  public void getUrl(String loginUrl) {
    this.driver.get(loginUrl);
  }

  public void sendText(String bjss) {
  }
}
