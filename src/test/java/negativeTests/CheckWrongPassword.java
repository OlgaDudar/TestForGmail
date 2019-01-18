package negativeTests;

import core.BO.LoginBO;
import coreTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWrongPassword extends BaseTest

    {
        @Test(threadPoolSize = 1, description = "negativeTests.Login with wrong password", groups = "negative")
        public void checkWrongPassword() {
        LoginBO loginBo = new LoginBO();
        loginBo.login(wrongUserToPassword);
        Assert.assertTrue(loginBo.getWrongPassword(), "WrongPassword");
    }
}
