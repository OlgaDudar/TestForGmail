package pages;

import core.elements.impl.Button;
import core.elements.impl.TextField;
import core.elements.impl.TextWarning;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private TextField inpMail;
    @FindBy(xpath = "//input[@type='password']")
    private TextField inpPass;
    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private Button btnNext;
    @FindBy(xpath = "//div[@class='GQ8Pzc']")
    private TextWarning warningMsg;

    public LoginPage(WebDriver dr) {
        super(dr);
    }

    @Step("Input account name")
    public boolean inputAccount(String mail){
        inpMail.type(mail);
        btnNext.click();
        return !(warningMsg.isDisplayed());
    }

    @Step("Input account password")
    public boolean inputPassword(String pass){
        inpPass.type(pass);
        btnNext.click();
        return !(warningMsg.isDisplayed());
    }
}
