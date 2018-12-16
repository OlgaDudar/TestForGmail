import core.model.Message;
import core.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

public class Tests extends BaseTestClass {

    @Test (description = "Login to Gmail and send message using Page Object Model")
    public void loginSendMail() throws Exception {
        User user = new User(getDataProperties("login"), getDataProperties("password"));
        Message msg = new Message(getDataProperties("sendTo"),"", "Hello");

        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(getDataProperties("site"));
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
    public void OpenInboxPage() throws Exception {
        User user = new User(getDataProperties("login"), getDataProperties("password"));
        Message msg = new Message(getDataProperties("sendTo"),"", "Hello");
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(getDataProperties("site"));
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