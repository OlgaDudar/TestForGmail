package coreTest;
import core.driver.WebDriverThreadLocal;
import core.model.Message;
import core.model.User;
import io.qameta.allure.Attachment;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class BaseTest {

    protected User user = null;
    protected Message msg;
    protected String pageUrl = null;
    protected String sys_prop = "system.properties";
    protected String sub_prop = "subject.properties";
    protected User wrongUserToAccount = null;
    protected User wrongUserToPassword = null;
    static Logger LOG = Logger.getLogger(BaseTest.class.getName());

    @BeforeSuite(groups = {"positive", "negative"})
    public void init(){
        LOG.info("INIT START");
        System.setProperty("webdriver.chrome.driver", getDataProperties("driverPath", sys_prop));
        pageUrl = getDataProperties("site", sys_prop);
    }

    @BeforeTest(groups = {"positive", "negative"})
    public void beforeTest(){
        wrongUserToAccount = new User("test", getDataProperties("password", sys_prop));
        wrongUserToPassword = new User(getDataProperties("login", sys_prop), "test");
    }

    @BeforeMethod(groups = {"positive", "negative"})
    public void setProp()  {
        LOG.info("START");
        String sub = RandomStringUtils.random(8, false, true);
        msg = new Message(getDataProperties("sendTo", sys_prop),  sub, "Hello");
        String pageUrl = getDataProperties("site", "system.properties");
        user = new User(getDataProperties("login", sys_prop), getDataProperties("password", sys_prop));
        wrongUserToAccount = new User("test", getDataProperties("password", sys_prop));
        wrongUserToPassword = new User(getDataProperties("login", sys_prop), "test");
    }

    @AfterMethod(groups = {"positive", "negative"})
    public void afterMethod(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()) {
            LOG.error("TEST FAILED ERROR CUSTOM MESSAGE");
            makeScreenshot();
        }
        if(ITestResult.SKIP==result.getStatus()) {
            makeScreenshot();
        }
        if(ITestResult.SUCCESS==result.getStatus()) {
            makeScreenshot();
        }
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

    @DataProvider (name = "deleteMessage", parallel = true)
    public Object[][] deleteMessage()
    {
        Object[][] data = new Object[1][1];
        String sub = getDataProperties("subject", sub_prop);
        data[0][0] = new Message(getDataProperties("sendTo", sys_prop), sub, "Hello");
        return data;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] makeScreenshot() {
        try{
            return ((TakesScreenshot) WebDriverThreadLocal.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
        catch(Exception ex){
            return null;
        }
    }

    @AfterSuite()
    public void runReport(){
        try {
            String projectDir = System.getProperty("user.dir");
            Process p = Runtime.getRuntime().exec("C:\\allure-commandline-2.9.0\\allure-2.9.0\\bin\\allure.bat generate "+projectDir+"\\target\\allure-results -o "+projectDir+"\\target\\allure-report");
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
