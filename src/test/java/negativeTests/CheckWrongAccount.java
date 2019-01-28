package negativeTests;

import core.BO.LoginBO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import coreTest.BaseTest;
@Epic("Regresion Tests")
@Feature("Check login tests")

public class CheckWrongAccount extends BaseTest {

    @Test(threadPoolSize = 1, description = "negativeTests.Login with wrong account", groups = {"negative"})
    @Story("Test check login to Gmail with wrong account")

    public void checkWrongAccount() {
        LoginBO loginBo = new LoginBO();
        loginBo.checkAccount(wrongUserToAccount);
        Assert.assertTrue(loginBo.getWrongAccount(), "Wrong Account");
    }
}