import core.driver.WebDriverThreadLocal;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;


public class TestWithoutBO extends BaseTestClass {

    @Test(description = "Login to Gmail and send message using Page Object Model")
    public void loginSendMailTest() {
        LoginPage loginPage = new LoginPage(WebDriverThreadLocal.getDriver());
        loginPage.openSite(pageUrl);
        loginPage.inputMail(user.getLogin());
        loginPage.inputPassword(user.getPassword());
        InboxPage inBox = new InboxPage(WebDriverThreadLocal.getDriver());
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
        Assert.assertTrue(inBox.sendMessagePopupDisplayed(), " Mail was not sent");
    }
}