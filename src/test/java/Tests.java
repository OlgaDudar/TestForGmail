import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

public class Tests extends BaseTestClass {

    @Test (description = "Login to Gmail and send message using Page Object Model")
    public void loginSendMailTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(pageUrl);
        loginPage.setMail(user.getLogin());
        loginPage.setPassword(user.getPassword());
        InboxPage inBox = new InboxPage();
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
        Assert.assertTrue(inBox.sendMessagePopupDisplayed(), " Mail was not sent");
    }

    @Test (description = "Open Inbox page and send message")
    public void openInboxPageTest()  {
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(pageUrl);
        loginPage.setMail(user.getLogin());
        loginPage.setPassword(user.getPassword());
        InboxPage inBox = new InboxPage();
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
        Assert.assertFalse(inBox.sendMessagePopupDisplayed(), " Mail was not sent");
    }
}