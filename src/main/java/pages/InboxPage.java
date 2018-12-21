package pages;

import core.driver.WebDriverSingleton;
import core.elements.impl.Button;
import core.elements.impl.PopUp;
import core.elements.impl.TextField;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends BasePage{
    boolean msgSend;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button btnNewMail;
    @FindBy(xpath = "//form[@class='bAs']")
    private WebElement formElement;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextField toWhomtxt;
    @FindBy(xpath = "//input[@class='aoT']")
    private TextField subject;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private Button btnSend;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextField Msg;
    @FindBy(xpath = "//div[@class='bBe']")
    private PopUp popUp;
    @FindBy(xpath = "//span[@class='bAq']")
    private WebElement popUpText;

    public InboxPage(WebDriver dr) {
        super(dr);
    }


    public void createNewMail(){

        btnNewMail.click();
    }

    public void setAddress(String to){
        toWhomtxt.type(to);
    }

    public void setSubject(String sub){
        subject.type(sub);
    }


    public void setMessage(String txt){

        Msg.type(txt + Keys.TAB);
    }

    public void sendMail(){

        btnSend.click();
    }

    public boolean sendMessagePopupDisplayed() {

        Wait<WebDriver> wait = new WebDriverWait(WebDriverSingleton.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(popUpText, "Лист надіслано."));
        return popUp.isDisplayed();

    }

}

