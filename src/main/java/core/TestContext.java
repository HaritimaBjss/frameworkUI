package core;

import cucumber.api.java.After;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private static TestContext testContext = new TestContext();

    private DriverSetup driverSetup = new DriverSetup();

    private static WebDriver webDriver;

    private TestContext() {
        if(this.webDriver == null){
        this.webDriver = driverSetup.getDriver();
        System.out.println(webDriver);
        }
    }

    public static TestContext getInstance() {
        return testContext;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void closeAll(){
        webDriver.close();
    }

}
