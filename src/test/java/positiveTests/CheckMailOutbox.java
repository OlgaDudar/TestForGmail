package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckMailOutbox extends BaseTest {

    @Test (dataProvider="getData",  threadPoolSize = 3, description = "Check message in outbox", groups = {"positive"})
    public void checkMailInOutbox(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        Assert.assertTrue(mailBO.checkMessageInOutbox(msg), " Mail not present in outbox");
    }

}