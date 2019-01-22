package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SendMail extends BaseTest {

    @Test(dataProvider="getData",  threadPoolSize = 3,  description = "positiveTests.SendMail with BO", groups = {"positive"})
    public void sendMail(Message msg) {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        Assert.assertTrue(mailBO.verifyMsgIsSent(), " Mail was not sent");
    }
}
