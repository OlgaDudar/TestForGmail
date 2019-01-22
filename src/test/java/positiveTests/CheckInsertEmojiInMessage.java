package positiveTests;

import core.BO.LoginBO;
import core.BO.MailBO;
import core.model.Message;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckInsertEmojiInMessage extends BaseTest {

    @Test(description = "positiveTests.SendMail with BO", groups = {"positive"})
    public void insertEmoji() {
        Message msg = new Message("", "", "");
        LoginBO loginBo = new LoginBO();
        loginBo.login(user);
        MailBO mailBO = new MailBO();
        mailBO.createMessage(msg);
        Assert.assertTrue(mailBO.checkInsertEmoji(), " Emoji not inserted");
    }

}