import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;


import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class BaseTestClass {

    User user = null;
    Message msg = null;
    String pageUrl = null;
    WebDriver driver;

    @BeforeClass
    public void setProp()  {
        try {
            System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            user = new User(getDataProperties("login"), getDataProperties("password"));
            pageUrl = getDataProperties("site");
            String sub = RandomStringUtils.random(8, false, true);
            setDataProperties("subject", sub);
            msg = new Message(getDataProperties("sendTo"), sub, "Hello");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @BeforeTest
    public void beforeMetod(){
      ;
    }


    @AfterMethod
    public void afterSuit(){
        WebDriverSingleton.closeDriver();
    }
    @DataProvider (name = "getData", parallel = true)
    public Object[][] getData()
    {
        
        Object[][] data = new Object[3][1];
        String sub = null;

        for (int i=0; i<3; i++) {
            try {
                sub = RandomStringUtils.random(8, false, true);
                setDataProperties("subject", sub);
                msg = new Message(getDataProperties("sendTo"), sub, "Hello");
            } catch (Exception e) {
                e.printStackTrace();
            }
            data[i][0] = new Message(getDataProperties("sendTo"),sub, "Hello");
        }
        return data;
    }



}
