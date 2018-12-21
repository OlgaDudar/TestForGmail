import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckMailOutbox extends BaseTestClass {

    @Test (dataProvider="getData",  threadPoolSize = 3, description = "Check messege in outbox")
    public void checkMailInOutbox(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        mailBO.checkMessageInOutbox(msg);
        Assert.assertTrue(mailBO.checkMessageInOutbox(msg), " Mail not present in outbox");
    }

}