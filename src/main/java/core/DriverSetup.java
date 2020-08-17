package core;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSetup  implements DriverSource {

  /**
   * Get a chrome driver given an instance identifier.
   *
   * @param driverManagerType The type of driver to load
   * @return The driver.
   *//*
    WebDriver getDriver(DriverManagerType driverManagerType) throws IllegalStateException {
        WebDriverManager
                .getInstance(driverManagerType)
                .forceDownload() // Ensure fresh driver is obtained, useful when Chrome (for example) has updated
                .setup();
        WebDriverManager.getInstance(driverManagerType).getDownloadedVersion();
        System.out.println(WebDriverManager.getInstance(driverManagerType).getDownloadedVersion());

        return this.driverInstances.computeIfAbsent(driverManagerType, k -> {
            try {
                Class<?> browserClass = Class.forName(driverManagerType.browserClass());
                Capabilities capabilities = this.browserCapabilities.get(driverManagerType);

                WebDriver webDriver;
                if (null == capabilities) {
                    webDriver = (WebDriver) browserClass.getDeclaredConstructor().newInstance();
                } else {
                    Class<?> optionsClass = capabilities.getClass();
                    webDriver = (WebDriver) browserClass.getDeclaredConstructor(optionsClass).newInstance(capabilities);
                }
                webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                return webDriver;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });

    }
*/


  private static final Logger LOGGER = LoggerFactory.getLogger(DriverSetup.class);
  /*
    private final Map<DriverManagerType, WebDriver> driverInstances = new ConcurrentHashMap<>();
    private Map<DriverManagerType, Capabilities> browserCapabilities;

    public DriverSetup() {
        Map<DriverManagerType, MutableCapabilities> caps = new HashMap<>();
        caps.put(DriverManagerType.CHROME, this.chromeOptions());
        caps.forEach((_k, v) -> v.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT));

        this.browserCapabilities = Collections.unmodifiableMap(caps);
    }

    private MutableCapabilities chromeOptions() {
        ChromeOptions caps = new ChromeOptions();
        // Note: don't add --headless here. Jira renders the screen differently for headless browsers and tests fail.
        caps.addArguments(
                "--no-sandbox",
                "--incognito",
                "--start-fullscreen"
        );
        return caps;
    }

    */
  static WebDriver driver;
  private Scenario scenario;

  @Before
  public void setup(Scenario scenario) {
    this.scenario = scenario;
  }

  public void write(String message) {
    scenario.write(message);
  }

  /** get the browser driver.
   * @return WebDriver
   */
  public WebDriver getDriver() {
    try {
      setupIeDriverBinary();
      final DesiredCapabilities internetExplorerCapabilities = new DesiredCapabilities();
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.DISMISS);
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
      return new InternetExplorerDriver(internetExplorerCapabilities);

    } catch (UnreachableBrowserException e) {
      write("Error due to " + e.getMessage());
      throw new UnreachableBrowserException(e.getMessage());
    }
  }

  private void setupIeDriverBinary() {
    try {
      if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS || SystemUtils.IS_OS_LINUX) {
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
      } else {
        System.getenv();
      }
    } catch (Exception e) {
      LOGGER.info("Driver Binary not setup correctly...");
      e.printStackTrace();
    }
  }

  @Override
  public WebDriver newDriver() {
    try {
      setupIeDriverBinary();
      final DesiredCapabilities internetExplorerCapabilities = new DesiredCapabilities();
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.DISMISS);
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
      internetExplorerCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
      return new InternetExplorerDriver(internetExplorerCapabilities);

    } catch (UnreachableBrowserException e) {
      write("Error due to " + e.getMessage());
      throw new UnreachableBrowserException(e.getMessage());
    }
  }

  @Override
  public boolean takesScreenshots() {
    return true;
  }
}
