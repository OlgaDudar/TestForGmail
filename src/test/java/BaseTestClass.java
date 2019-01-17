import core.driver.WebDriverThreadLocal;
import core.model.Message;
import core.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class BaseTestClass {

    User user = null;
    Message msg = null;
    String pageUrl = null;
    String sys_prop = "system.properties";
    String sub_prop = "subject.properties";
    WebDriver driver;

    @BeforeClass
    public void setProp()  {
        try {
            System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath", sys_prop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            user = new User(getDataProperties("login", sys_prop), getDataProperties("password", sys_prop));
            pageUrl = getDataProperties("site", sys_prop);
            String sub = RandomStringUtils.random(8, false, true);
            setDataProperties("subject", sub_prop, sub);
            msg = new Message(getDataProperties("sendTo", sys_prop),  sub, "Hello");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void afterSuit(){
        WebDriverThreadLocal.closeDriver();
    }

    @DataProvider (name = "getData", parallel = true)
    public Object[][] getData()
    {
        Object[][] data = new Object[3][1];
        String sub = null;
        for (int i=0; i<3; i++) {
            try {
                sub = RandomStringUtils.random(8, false, true);
                setDataProperties("subject", sub_prop, sub);
                msg = new Message(getDataProperties("sendTo", sys_prop), sub, "Hello");
            } catch (Exception e) {
                e.printStackTrace();
            }
            data[i][0] = new Message(getDataProperties("sendTo", sys_prop),sub, "Hello");
        }
        return data;
    }

    @DataProvider (name = "getMessage", parallel = true)
    public Object[][] getMessage()
    {
        Object[][] data = new Object[1][1];
        String sub = "Fwd: 자동화 어디에서나 MetaBot Logic 실행 완료";
        data[0][0] = new Message("olga.dudar@gmail.com",sub, "Hello");
        return data;
    }



}
