import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.testng.annotations.*;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

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
            String sub = getDataProperties("subject").concat("2");
            setDataProperties("subject", sub);
            user = new User(getDataProperties("login"), getDataProperties("password"));
            msg = new Message(getDataProperties("sendTo"),sub, "Hello");
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
