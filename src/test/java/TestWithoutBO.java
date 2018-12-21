import core.driver.WebDriverSingleton;
import core.model.Message;
import core.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class TestWithoutBO extends BaseTestClass {
    @BeforeTest
    public void beforeMetod(){
        try {
            String sub = RandomStringUtils.random(8, false, true);
            setDataProperties("subject", sub);
            user = new User(getDataProperties("login"), getDataProperties("password"));
            msg = new Message(getDataProperties("sendTo"),sub, "Hello");
            pageUrl = getDataProperties("site");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(description = "Login to Gmail and send message using Page Object Model")
    public void loginSendMailTest() {
        LoginPage loginPage = new LoginPage(WebDriverSingleton.getDriver());
        loginPage.openSite(pageUrl);
        loginPage.inputMail(user.getLogin());
        loginPage.inputPassword(user.getPassword());
        InboxPage inBox = new InboxPage(WebDriverSingleton.getDriver());
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
        Assert.assertTrue(inBox.sendMessagePopupDisplayed(), " Mail was not sent");
    }
}
