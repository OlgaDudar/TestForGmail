package negativeTests;

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

public class CheckMailWithoutAnyData extends BaseTest {

    @Test(description = "negative.SendMail without adress and subject", groups = {"negative"})
    @Story("Test check send email without adress and subject")
    public void sendMail() {
        Message msg = new Message("", "","");
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        Assert.assertTrue(mailBO.verifyEmptyAdress(), " Error");
    }
}
