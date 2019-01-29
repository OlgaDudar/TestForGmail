package negativeTests;

import core.BO.LoginBO;
import coreTest.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Regresion Tests")
@Feature("Check login tests")

public class CheckWrongPassword extends BaseTest
{
    @Test(threadPoolSize = 1, description = "negativeTests.Login with wrong password", groups = {"negative"})
    @Story("Test check login to Gmail with wrong password")

    public void checkWrongPassword() {
        LoginBO loginBo = new LoginBO();
        loginBo.login(wrongUserToPassword);
        Assert.assertTrue(loginBo.getWrongPassword(), "WrongPassword");
    }
}
