package selenium_tests.pages;

import core.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private TestContext context = TestContext.getInstance();


    public LandingPage() {
        this.driver = context.getWebDriver();
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public void getUrl(String loginUrl) {
        this.driver.get(loginUrl);
    }

}
