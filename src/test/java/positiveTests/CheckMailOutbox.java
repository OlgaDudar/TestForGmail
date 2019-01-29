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

public class CheckMailOutbox extends BaseTest {

    @Test (dataProvider="getData",  threadPoolSize = 3, description = "positiveTests.Check message in outbox", groups = {"positive"})
    @Story("Check that sent mail is present in OutBox")
    public void checkMailInOutbox(Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        mailBO.verifyMsgIsSent();
        Assert.assertTrue(mailBO.checkMessageInOutbox(msg), " Mail not present in outbox");
    }

}