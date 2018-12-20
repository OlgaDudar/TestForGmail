import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.testng.annotations.*;

import static core.DataProperties.getDataProperties;

public class BaseTestClass {

    User user = null;
    Message msg = null;
    String pageUrl = null;

    @BeforeClass
    public void setProp()  {
        try {
            System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath"));
        } catch (Exception e) {
            e.printStackTrace();
        }

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

}
