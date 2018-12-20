package core.BO;

import core.model.User;
import pages.LoginPage;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    LoginPage loginPage = new LoginPage();

    public LoginBO() {
    ;
    }
    public void login (User user){
        String pageUrl = getDataProperties("site");
        loginPage.OpenSite(pageUrl);
        loginPage.setMail(user.getLogin());
        loginPage.setPassword(user.getPassword());
    }
}
