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
public class CheckInsertEmojiInMessage extends BaseTest {

    @Test(description = "positiveTests.SendMail with BO", groups = {"positive"})
    @Story("Check that Emoji was set in message")
    public void insertEmoji() {
        Message msg = new Message("", "", "");
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.createMessage(msg);
        Assert.assertTrue(mailBO.checkInsertEmoji(), " Emoji not inserted");
    }

}