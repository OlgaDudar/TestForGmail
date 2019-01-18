package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadAttachment extends BaseTest {

    @Test(dataProvider="getMessage",  threadPoolSize = 3, description = "Check download message", groups = "positive")
    public void downloadAttachment(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        Assert.assertTrue(mailBO.downloadAttachment(msg), " Mail not have attachment");
    }

}
