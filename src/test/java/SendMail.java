import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import core.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class SendMail extends BaseTestClass {
    @BeforeTest
    public void beforeMetod(){
        try {
            String sub = RandomStringUtils.random(8, false, true);
            setDataProperties("subject", sub);
            user = new User(getDataProperties("login"), getDataProperties("password"));
            msg = new Message(getDataProperties("sendTo"),sub, "Hello");
            pageUrl = getDataProperties("site");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "SendMail with BO")
    public void sendMail() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        Assert.assertTrue(mailBO.verifyMsgIsSent(), " Mail was not sent");
    }
}
