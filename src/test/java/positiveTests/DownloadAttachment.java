package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Regresion Tests")
@Feature("Work with mail")
public class DownloadAttachment extends BaseTest {

    @Test(dataProvider="getMessage",  threadPoolSize = 3, description = "positiveTests.Check download message", groups = {"positive"})
    @Story("Check that attashment was download in archive")
    public void downloadAttachment(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        Assert.assertTrue(mailBO.downloadAttachment(msg), " Mail not have attachment");
    }

}
