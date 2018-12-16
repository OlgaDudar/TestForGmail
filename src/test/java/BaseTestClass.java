import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BaseTestClass {
    User user = null;
    Message msg = null;

    @BeforeClass
    public void setProp() throws Exception {
        System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath"));

        try {
            user = new User(getDataProperties("login"), getDataProperties("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            msg = new Message(getDataProperties("sendTo"),"", "Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @BeforeTest
    public void beforeTest(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
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
