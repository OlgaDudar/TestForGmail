import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTestClass {

    private Tests(){};


    @Test (description = "Login to Gmail and send masage using Page Object Model")
    public void loginSendMail() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite(getDataProperties("site"));
        loginPage.setMail(getDataProperties("login"));
        loginPage.setPassword(getDataProperties("password"));
        InboxPage inBox = new InboxPage();
        inBox.createNewMail();
        inBox.setAdress(getDataProperties("sendTo"));
        inBox.setMassage("Hello");
        inBox.sendMassage();
        Assert.assertTrue(inBox.msgSend, " Mail not sended");
    }
}