package core.BO;

import core.driver.WebDriverSingleton;
import core.model.Message;
import pages.InboxPage;
import pages.OutBox;

public class MailBO {

    InboxPage  inBox = new InboxPage(WebDriverSingleton.getDriver());

    public MailBO(){
        ;
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
        OutBox outBox = new OutBox(WebDriverSingleton.getDriver());
        outBox.goToOutBox();
        return outBox.checkMessageIsPresent(msg);
    }
}
