package core.BO;

import core.driver.WebDriverThreadLocal;
import core.model.Message;
import pages.InboxPage;
import pages.LetterPage;
import pages.OutBox;

public class MailBO {

    InboxPage  inBox;

    public MailBO(){
        inBox = new InboxPage(WebDriverThreadLocal.getDriver());
    }

    public void sendMessage(Message msg){
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setSubject(msg.getSubject());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
    }
    public boolean verifyMsgIsSent(){

        return inBox.sendMessagePopupDisplayed();
    }

    public boolean checkMessageInOutbox(Message msg){
        OutBox outBox = new OutBox(WebDriverThreadLocal.getDriver());
        outBox.goToOutBox();
        return outBox.checkMessageIsPresent(msg);
    }

    public boolean downloadAttachment(Message msg){
        LetterPage letter = new LetterPage(WebDriverThreadLocal.getDriver());
        letter.openLetter(msg);
        letter.DownloadAttachment();
        return true;
    }
}
