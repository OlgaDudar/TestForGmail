package negativeTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckMailWithWrongAddress extends BaseTest {

    @Test(description = "negative.SendMail with BO", groups = {"negative"})
    public void sendMail() {
        Message msg = new Message("test.test", "qwe","");
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        Assert.assertTrue(mailBO.verifyWrongAddress(), " Error");
    }

}
