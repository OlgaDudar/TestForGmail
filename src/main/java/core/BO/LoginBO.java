package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.User;
import pages.LoginPage;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    private LoginPage loginPage;
    private boolean wrongAccount = false ;
    private boolean wrongPassword = false;



    public LoginBO() {
        loginPage = new LoginPage(WebDriverThreadLocal.getDriver());
    }

    public boolean getWrongAccount(){
        return wrongAccount;
    }

    public boolean getWrongPassword(){
        return wrongPassword;
    }

    public void checkAccount(User user) {
        String pageUrl = getDataProperties("site", "system.properties");
        loginPage.openSite(pageUrl);
        if(!loginPage.inputAccount(user.getLogin())) {
            wrongAccount = true;
        }
    }

    public void login (User user){
        String pageUrl = getDataProperties("site", "system.properties");
        loginPage.openSite(pageUrl);
        if(!loginPage.inputAccount(user.getLogin())) {
            wrongAccount = true;
        }
        if(!loginPage.inputPassword(user.getPassword())) {
            wrongPassword = true;
        }
    }

}
