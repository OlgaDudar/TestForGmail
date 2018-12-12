import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTestClass {

    private Tests(){};


    @Test (description = "Login to Gmail and send message using Page Object Model")
    public void loginSendMail() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(getDataProperties("site"));
        loginPage.setMail(getDataProperties("login"));
        loginPage.setPassword(getDataProperties("password"));
        InboxPage inBox = new InboxPage();
        inBox.createNewMail();
        inBox.setAddress(getDataProperties("sendTo"));
        inBox.setMessage("Hello");
        inBox.sendMail();
        Assert.assertTrue(inBox.sendMessagePopupDisplayed(), " Mail was not sent");
    }
}