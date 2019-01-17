package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.User;
import pages.LoginPage;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    LoginPage loginPage;


    public LoginBO() {
    loginPage = new LoginPage(WebDriverThreadLocal.getDriver());;
    }

    public void login (User user){
        String pageUrl = getDataProperties("site", "system.properties");
        loginPage.openSite(pageUrl);
        loginPage.inputMail(user.getLogin());
        loginPage.inputPassword(user.getPassword());
    }
}
