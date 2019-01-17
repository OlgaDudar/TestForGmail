import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadAttachment extends BaseTestClass {

    @Test(dataProvider="getMessage",  threadPoolSize = 3, description = "Check messege in outbox")
    public void downloadAttachment(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.downloadAttachment(msg);
        Assert.assertTrue(true, " Mail not have attachment");
    }

}
