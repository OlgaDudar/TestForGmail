import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SendMail extends BaseTestClass {


    @Test(dataProvider="getData",  threadPoolSize = 3,  description = "SendMail with BO")
    public void sendMail(Message msg) {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        Assert.assertTrue(mailBO.verifyMsgIsSent(), " Mail was not sent");
    }
}
