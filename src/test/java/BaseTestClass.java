import core.driver.WebDriverSingleton;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BaseTestClass {
    @BeforeClass
    public void setProp() throws Exception {
        System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath"));
    }

    @AfterSuite
    public void afterSuit(){
       WebDriverSingleton.getInstance().quit();
    }

    public static String getDataProperties (String param) throws Exception {
        Properties props;
        props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("system.properties")));
        return props.getProperty(param);
    }
}
