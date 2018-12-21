package core.BO;

import core.driver.WebDriverSingleton;
import core.model.User;
import pages.LoginPage;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    LoginPage loginPage = new LoginPage(WebDriverSingleton.getDriver());

    public LoginBO() {
    ;
    }
    public void login (User user){
        String pageUrl = getDataProperties("site");
        loginPage.openSite(pageUrl);
        loginPage.inputMail(user.getLogin());
        loginPage.inputPassword(user.getPassword());
    }
}
