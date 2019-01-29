package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.User;
import org.apache.log4j.Logger;
import pages.BasePage;
import pages.LoginPage;

import java.util.Date;

import static core.DataProperties.getDataProperties;

public class LoginBO {
    private LoginPage loginPage;
    private boolean wrongAccount = false ;
    private boolean wrongPassword = false;
    private Logger logger = Logger.getLogger(BasePage.class.getName());
    private Date objDate = new Date();


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
        logger.info("Check account "+objDate.toString()+getClass());
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
        logger.info("Login to GMail "+objDate.toString()+getClass());
    }

}
