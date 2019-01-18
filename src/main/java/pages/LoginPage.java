package pages;

import core.elements.impl.Button;
import core.elements.impl.TextField;
import core.elements.impl.TextWarning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    public TextField inpMail;
    @FindBy(xpath = "//input[@type='password']")
    public TextField inpPass;
    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    public Button btnNext;
    @FindBy(xpath = "//div[@class='GQ8Pzc']")
    public TextWarning warningMsg;


    public LoginPage(WebDriver dr) {
        super(dr);
    }

    public boolean inputAccount(String mail){
        inpMail.type(mail);
        btnNext.click();
        return !(warningMsg.isDisplayed());

    }

    public boolean inputPassword(String pass){
        inpPass.type(pass);
        btnNext.click();
        return !(warningMsg.isDisplayed());
    }
}
