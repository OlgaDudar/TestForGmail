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

    }


    @AfterMethod
    public void afterSuit(){
        WebDriverSingleton.closeDriver();
    }

}
