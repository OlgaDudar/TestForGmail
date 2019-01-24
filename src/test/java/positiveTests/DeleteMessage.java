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
public class DeleteMessage extends BaseTest {

    @Test(dataProvider="deleteMessage",  threadPoolSize = 1, description = "Delete message", groups = {"positive"})
    @Story("Check that message from list was deleted when click on Delete(Trash) button")
    public void deleteMail (Message msg)  {
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.deleteMessage(msg);
        Assert.assertTrue(mailBO.deleteMailPopup(), " Mail was not deleted");
    }
}
