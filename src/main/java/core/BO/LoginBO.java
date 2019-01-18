package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.User;
import pages.LoginPage;

import java.util.logging.Logger;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    private LoginPage loginPage;
    private Logger log = Logger.getLogger("devpinoyLogger");
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
        log.fine("Site Opened");
        if(!loginPage.inputAccount(user.getLogin())) {
            wrongAccount = true;
            log.warning("Wrong account");
        }
    }

    public void login (User user){
        String pageUrl = getDataProperties("site", "system.properties");
        loginPage.openSite(pageUrl);
        if(!loginPage.inputAccount(user.getLogin())) {
            wrongAccount = true;
            log.warning("Wrong account");
        }
        if(!loginPage.inputPassword(user.getPassword())) {
            wrongPassword = true;
            log.warning("Wrong password");
        }
    }

}
