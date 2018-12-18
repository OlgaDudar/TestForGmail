import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BaseTestClass {

    User user = null;
    Message msg = null;
    String pageUrl = null;

    @BeforeClass
    public void setProp() throws Exception {
        System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath"));

        try {
            user = new User(getDataProperties("login"), getDataProperties("password"));
            msg = new Message(getDataProperties("sendTo"),"", "Hello");
            pageUrl = getDataProperties("site");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @BeforeTest
    public void beforeTest(){
      ;
    }

    @AfterMethod
    public void afterSuit(){
        WebDriverSingleton.closeDriver();
    }

    public static String getDataProperties (String param) throws Exception {
        Properties props;
        props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("system.properties")));
        return props.getProperty(param);
    }
}
