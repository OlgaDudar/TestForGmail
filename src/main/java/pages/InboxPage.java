package pages;

import core.elements.impl.Button;
import core.elements.impl.PopUp;
import core.elements.impl.TextField;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class InboxPage extends BasePage{
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button btnNewMail;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextField toWhomtxt;
    @FindBy(xpath = "//input[@class='aoT']")
    private TextField subject;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private Button btnSend;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextField msg;
    @FindBy(xpath = "//div[@class='bBe']")
    private PopUp popUp;
    @FindBy(xpath = "//span[@class='bAq']")
    private WebElement popUpText;
    @FindBy(xpath = "//div[@class='Kj-JD-K7 Kj-JD-K7-bsT']")
    private PopUp errorMsgBox;
    @FindBy(xpath = "//div[@class='QT aaA aMZ']")
    private Button insertEmoji;
    @FindBy(xpath = "//button[@class='a8m']/span[@class='AdOhId tGvGdc']//div[@class='e1f600 a8r']")
    private Button emoji;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']/img[@goomoji='1f600']")
    private Button emojiInMessage;
    @FindBy(xpath = "//div[@class='Kj-JD']")
    private PopUp warningWrongAddress;

    private Logger logger = Logger.getLogger(BasePage.class.getName());
    public InboxPage(WebDriver dr) {
        super(dr);
    }

    @Step("Insert Emoji in Message")
    public void insertEmoji(){
        insertEmoji.click();
        emoji.click();
        logger.info("INSERT EMOJI");
    }

    @Step("Check Emoji is present in Message")
    public boolean checkEmojiIsPresentOnMessage(){
        return emojiInMessage.isDisplayed();
    }

    @Step("Click on New Mail button")
    public void createNewMail(){
        btnNewMail.click();
        logger.info("NEW MAIL");
    }

    @Step("Input address")
    public void setAddress(String to){
        toWhomtxt.type(to);
        logger.info("INPUT ADDRESS");
    }

    @Step("Input subject")
    public void setSubject(String sub){
        subject.type(sub);
        logger.info("INPUT SUBJECT");
    }

    @Step("Input message")
    public void setMessage(String txt){
        msg.type(txt + Keys.TAB);
        logger.info("INPUT MESSAGE");
    }

    @Step("Click on Send button")
    public void sendMail(){
        btnSend.click();
        logger.info("SEND MAIL");
    }

    @Step("Check that message about sent mail is appeared")
    public boolean sendMessagePopupDisplayed() {
        return waitTextIsVisibleInElement(popUpText, "Лист надіслано.");
    }

    public boolean warningMessagesDisplayed() {
        return errorMsgBox.isEnabled();
    }

    public boolean warningMessageAddressIsDisplayed() {
        return warningWrongAddress.isEnabled();
    }


}

