package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMessage extends BaseTest {

    @Test(dataProvider="deleteMessage",  threadPoolSize = 1, description = "Delete message", groups = {"positive"})
    public void deleteMail (Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.deleteMessage(msg);
        Assert.assertTrue(mailBO.deleteMailPopup(), " Mail was not deleted");
    }
}
