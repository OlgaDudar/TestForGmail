package negativeTests;

import core.BO.LoginBO;
import org.testng.Assert;
import org.testng.annotations.Test;
import coreTest.BaseTest;

public class CheckWrongAccount extends BaseTest {

    @Test(threadPoolSize = 1, description = "negativeTests.Login with wrong account", groups = {"negative"})
    public void checkWrongAccount() {
        LoginBO loginBo = new LoginBO();
        loginBo.checkAccount(wrongUserToAccount);
        Assert.assertTrue(loginBo.getWrongAccount(), "Wrong Account");
    }
}