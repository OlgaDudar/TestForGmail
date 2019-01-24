package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.Message;
import org.openqa.selenium.UnhandledAlertException;
import pages.InboxPage;
import pages.LetterPage;
import pages.OutBoxPage;


public class MailBO {

    private InboxPage  inBox;
    private OutBoxPage outBox;

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
    }

    public void createMessage(Message msg) {
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setSubject(msg.getSubject());
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
    }
    public boolean deleteMailPopup() {
        return outBox.isDeleteMailPopupIsPresent();
    }

    public boolean downloadAttachment(Message msg){
        LetterPage letter = new LetterPage(WebDriverThreadLocal.getDriver());
        letter.DownloadAttachment();
        return true;
    }

    public boolean verifyWrongAddress() {
        return inBox.warningMessageAddressIsDisplayed();
    }
}
