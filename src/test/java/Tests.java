import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTestClass {

    private Tests(){};


    @Test (description = "Login to Gmail and send masage using Page Object Model")
    public void loginSendMail(){
        LoginPage loginPage = new LoginPage();
        loginPage.OpenSite("https://mail.google.com");
        loginPage.setMail("test18.acount18@gmail.com");
        loginPage.setPassword("qwerty18()");
        InboxPage inBox = new InboxPage();
        inBox.createNewMail();
        inBox.setAdress("olha.dudar@gmail.com");
        inBox.setMassage("Hello");
        inBox.sendMassage();
        Assert.assertTrue(inBox.msgSend, " Mail not sended");
    }
}