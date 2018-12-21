import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import core.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static core.DataProperties.getDataProperties;
import static core.DataProperties.setDataProperties;

public class CheckMailOutbox extends BaseTestClass {
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

       @Test (description = "Check messege in outbox")
    public void checkMailInOutbox()  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        mailBO.checkMessageInOutbox(msg);
        Assert.assertTrue(mailBO.checkMessageInOutbox(msg), " Mail not present in outbox");
    }

}