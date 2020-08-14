package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    Properties prop = new Properties();

    public ReadProperties() {
        try{
            InputStream propFile = new FileInputStream("src/test/java/selenium_tests/resources/selenium.properties");
            prop.load(propFile);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getLoginUrl() {
        return prop.getProperty("server.url");
    }
}
