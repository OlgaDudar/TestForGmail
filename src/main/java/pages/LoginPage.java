package pages;

import core.elements.impl.Button;
import core.elements.impl.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    public TextField inpMail;
    @FindBy(xpath = "//input[@type='password']")
    public TextField inpPass;
    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    public Button btnNext;

    public LoginPage(WebDriver dr) {
        super(dr);
    }

    public void inputMail(String mail){
        inpMail.type(mail);
        btnNext.click();
    }

    public void inputPassword(String pass){
        inpPass.type(pass);
        btnNext.click();
    }
}
