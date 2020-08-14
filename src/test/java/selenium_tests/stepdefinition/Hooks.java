package selenium_tests.stepdefinition;

import core.TestContext;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;


public class Hooks {

    private  WebDriver driver;

    @After
    public void afterScenario() {
        System.out.println("Cleaning up browsers");
        TestContext.getInstance().closeAll();
        System.out.println("Cleaned up browsers");
    }
}