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

public class CheckMailWithWrongAddress extends BaseTest {

    @Test(description = "negative.SendMail with wrong adress", groups = {"negative"})
    @Story("Test check send email with wrong adress")

    public void sendMail() {
        Message msg = new Message("test.test", "qwe","");
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.sendMessage(msg);
        Assert.assertTrue(mailBO.verifyWrongAddress(), " Error");
    }

}
