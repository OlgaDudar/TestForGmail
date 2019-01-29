package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.Message;
import org.apache.log4j.Logger;
import org.openqa.selenium.UnhandledAlertException;
import pages.BasePage;
import pages.InboxPage;
import pages.LetterPage;
import pages.OutBoxPage;

import java.util.Date;


public class MailBO {

    private InboxPage  inBox;
    private OutBoxPage outBox;
    private Logger logger = Logger.getLogger(BasePage.class.getName());
    private Date objDate = new Date();

    public MailBO(){

        inBox = new InboxPage(WebDriverThreadLocal.getDriver());
        outBox = new OutBoxPage(WebDriverThreadLocal.getDriver());
    }

    public void sendMessage(Message msg){
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setSubject(msg.getSubject());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
        logger.info("Sent mail "+objDate.toString()+getClass());

    }

    public void createMessage(Message msg) {
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setSubject(msg.getSubject());
        logger.info("Create new mail "+objDate.toString()+getClass());
    }

    public boolean checkInsertEmoji(){
        inBox.insertEmoji();
        return inBox.checkEmojiIsPresentOnMessage();
    }

    public boolean checkPopupAlertIsDisplayed(){
        try {
            System.out.println(inBox.getTitle());
        }
       catch (UnhandledAlertException exception){
           return exception.getMessage().contains("Надіслати це повідомлення без теми й тексту?");
       }
       return false;
    }
    public boolean verifyMsgIsSent(){

        return inBox.sendMessagePopupDisplayed();
    }
    public boolean verifyEmptyAdress(){
        return inBox.warningMessagesDisplayed();
    }

    public boolean checkMessageInOutbox(Message msg){
        outBox.goToOutBox();
        return outBox.checkMessageIsPresent(msg);
    }

    public void deleteMessage(Message msg){
        outBox.goToOutBox();
        outBox.selectMail(msg);
        outBox.deleteMail(msg);
        logger.info("Delete message "+objDate.toString()+getClass());
    }
    public boolean deleteMailPopup() {
        return outBox.isDeleteMailPopupIsPresent();
    }

    public boolean downloadAttachment(Message msg){
        LetterPage letter = new LetterPage(WebDriverThreadLocal.getDriver());
        letter.DownloadAttachment();
        logger.info("Download attashment "+objDate.toString()+getClass());
        return true;
    }

    public boolean verifyWrongAddress() {
        return inBox.warningMessageAddressIsDisplayed();
    }
}
